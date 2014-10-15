package com.tdd.model.ghost;

import com.tdd.model.direction.*;
import com.tdd.model.exceptions.BlockedCellException;
import com.tdd.model.stage.SquaredArea;
import com.tdd.model.stageAbstractions.Direction;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.Position;
import com.tdd.model.stageAbstractions.Protagonist;
import java.util.ArrayList;
import java.util.Random;

public abstract class Strategy {

    protected Enemy enemy;
    protected int vision;
    protected SquaredArea area;
    protected ArrayList<Direction> possibleDirections;
    protected int directionIndex;
    protected Direction lastDirection;
    protected int bifurcationCells = 3;

    public Strategy(Enemy givenEnemy, int vision) {
        this.enemy = givenEnemy;
        this.vision = vision;
        this.possibleDirections = new ArrayList<>();
        this.lastDirection = null;
    }

    public Direction getDirection() {
        if (possibleDirections.isEmpty()) {
            this.getPossibleDirections();
        }
        directionIndex++;
        return possibleDirections.get(directionIndex - 1);
    }

    public void getPossibleDirections() {
        this.area = new SquaredArea(this.enemy.getPosition(), this.vision);
        Protagonist pacman = this.enemy.getProtagonist();
        boolean pacmanIsVisible = pacman.isInArea(this.area);
        if (pacmanIsVisible == true) {
            this.chasePacman(pacman.getPosition());
        } else {
            this.getRandomDirection();
        }
    }

    public void advanceCycle() {
        this.area = new SquaredArea(this.enemy.getPosition(), this.vision);
        this.lastDirection = this.possibleDirections.get(this.directionIndex);
        this.possibleDirections.clear();
        this.directionIndex = 0;
    }

    //guarda las 4 direcciones posibles segun su prioridad en this.possibleDirections
    //hay que guardar direccion anterior para seguir siempre la misma direccion al 
    //entrar a un canal.
    public void getRandomDirection() {
        if (inCellBifurcation() || this.lastDirection == null) {
            generateRandomDirections();
        } else {
            getNoBifurcationDirections();
        }
    }

    public void chasePacman(Position givenPosition) {
        ArrayList<Direction> directions = this.getAllDirections();
        ArrayList<Double> distances = this.getAllDistances(givenPosition);
        while (!distances.isEmpty()) {
            int indexMin = 0;
            double min = distances.get(0);
            for (int x = 0; x < distances.size(); x++) {
                if (distances.get(x) < min) {
                    min = distances.get(x);
                    indexMin = x;
                }
            }
            this.possibleDirections.add(directions.remove(indexMin));
            distances.remove(indexMin);
        }
    }

    private boolean inCellBifurcation() {
        int unblockedCells = 0;
        ArrayList<Position> positions = getAllPossibleNextPositions();
        for (Position position : positions) {
            try {
                this.enemy.getStage().getCell(position).testPlaceElement();
                unblockedCells++;
            } catch (BlockedCellException error) {
            }
        }
        if (unblockedCells >= bifurcationCells) {
            return true;
        }
        return false;
    }

    private void generateRandomDirections() {
        ArrayList<Direction> directions = this.getAllDirections();
        while (!directions.isEmpty()){        
            int index = getRandomNumber(directions.size() - 1, 0);
            this.possibleDirections.add(directions.remove(index));            
        }        
    }

    private void getNoBifurcationDirections() {
        //seguir hacia adelante
        //segundo hacia atras
        //demases
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    private int getRandomNumber(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }
    
    
    private ArrayList<Direction> getAllDirections() {
        ArrayList<Direction> directions = new ArrayList<>();
        directions.add(new DirectionLeft());
        directions.add(new DirectionRight());
        directions.add(new DirectionUp());
        directions.add(new DirectionDown());
        return directions;
    }

    private ArrayList<Double> getAllDistances(Position givenPosition) {
        ArrayList<Position> positions = getAllPossibleNextPositions();
        ArrayList<Double> distances = new ArrayList<>();
        for (Position position : positions) {
            distances.add(givenPosition.getDistance(position));
        }
        return distances;
    }

    private ArrayList<Position> getAllPossibleNextPositions() {
        ArrayList<Position> positions = new ArrayList<>();
        positions.add(this.enemy.getPosition().createPositionSubstractingX(this.enemy.getPosition().getX()));
        positions.add(this.enemy.getPosition().createPositionAddingX(this.enemy.getPosition().getX()));
        positions.add(this.enemy.getPosition().createPositionAddingY(this.enemy.getPosition().getY()));
        positions.add(this.enemy.getPosition().createPositionSubstractingY(this.enemy.getPosition().getY()));
        return positions;
    }
}
