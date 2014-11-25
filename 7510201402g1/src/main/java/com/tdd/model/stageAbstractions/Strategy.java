package com.tdd.model.stageAbstractions;

import com.tdd.model.direction.*;
import com.tdd.model.exceptions.BlockedCellException;
import com.tdd.model.exceptions.NoExistingCellException;
import com.tdd.model.helpers.RandomNumberGenerator;
import com.tdd.model.stage.SquaredArea;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Strategy {

    protected MovedByStrategy element;
    protected int vision;
    protected SquaredArea area;
    protected ArrayList<Direction> possibleDirections;
    protected int directionIndex = 0;
    protected Direction lastDirection;
    protected int bifurcationCells = 3;

    public Strategy(MovedByStrategy givenElement, int vision) {
        this.element = givenElement;
        this.vision = vision;
        this.possibleDirections = new ArrayList<>();
        if (this.element != null) {
            this.lastDirection = this.element.getSense();
        }
    }

    public void advanceCycle() {
        this.area = new SquaredArea(this.element.getPosition(), this.vision);
        try {
            this.lastDirection = this.possibleDirections.get(this.directionIndex);
        } catch (Exception arrayIndexOutOfBoundsException) {
            return;
        }
        this.possibleDirections.clear();
        this.directionIndex = 0;
    }

    public Direction getDirection() {
        if (possibleDirections.isEmpty()) {
            this.getPossibleDirections();
            this.directionIndex = 0;
        }
        if (this.directionIndex <= possibleDirections.size()) {
            this.lastDirection = possibleDirections.get(this.directionIndex);
            return possibleDirections.get(this.directionIndex);
        } else {            
            return new DirectionRight();
        }
    }

    public void getPossibleDirections() {
        this.area = new SquaredArea(this.element.getPosition(), this.vision);
        Protagonist pacman = this.element.getProtagonist();
        if (pacman != null) {
            boolean pacmanIsVisible = pacman.isInArea(this.area);
            if (pacmanIsVisible == true) {             
                this.chasePacman(pacman.getPosition());
                return;
            }
        }
        this.getRandomDirection();
    }

    public void chasePacman(Position givenPosition) {
        if (givenPosition == null) {
            return;
        }
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

    public void getRandomDirection() {
        if (this.lastDirection != null) {
            this.possibleDirections.add(this.lastDirection);
        }
        if (inCellBifurcation() || this.lastDirection == null) {
            generateRandomDirections();
        } else {
            getNoBifurcationDirections();
        }
    }

    protected boolean inCellBifurcation() {
        int unblockedCells = 0;
        List<Direction> directions = getAllDirections();
        Position elementPosition = this.element.getPosition();
        for (Direction direction : directions) {
            try {
                this.element.getStage().getCell(elementPosition).getTargetPosition(direction);
                unblockedCells++;
            } catch (BlockedCellException | NoExistingCellException error) {
            }
        }
        return (unblockedCells >= bifurcationCells);
    }

    protected void generateRandomDirections() {
        ArrayList<Direction> directions = this.getAllDirections();
        while (!directions.isEmpty()) {
            int index = RandomNumberGenerator.getRandomNumber(0, directions.size() - 1);
            this.possibleDirections.add(directions.remove(index));
        }
    }

    protected void getNoBifurcationDirections() {
        if (this.lastDirection != null) {
            this.possibleDirections.add(this.lastDirection);
            this.possibleDirections.add(this.lastDirection.invert());
        }
        this.generateRandomDirections();
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
        ArrayList<Direction> directions = getAllDirections();
        for (Direction direction : directions) {
            positions.add(direction.getNewPosition(this.element.getPosition()));
        }
        return positions;
    }

    public int getNumberOfPossibleDirections() {
        return this.possibleDirections.size();
    }

    public Direction getLastDirection() {
        return this.lastDirection;
    }

    public void setLastDirection(Direction direction) {
        this.lastDirection = direction;
    }

    public void nextDirection() {
        this.directionIndex++;
    }
}
