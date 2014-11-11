package com.tdd.model.stageAbstractions;

import com.tdd.model.direction.*;
import com.tdd.model.exceptions.BlockedCellException;
import com.tdd.model.exceptions.NoExistingCellException;
import com.tdd.model.stage.SquaredArea;
import java.util.ArrayList;
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
        this.lastDirection = null;
    }

    public void advanceCycle() {
        this.area = new SquaredArea(this.element.getPosition(), this.vision);

        try {
            this.lastDirection = this.possibleDirections.get(this.directionIndex - 1);
        } catch (Exception arrayIndexOutOfBoundsException) {
            return;
        }

        this.possibleDirections.clear();
        this.directionIndex = 0;
    }

    public Direction getDirection() {
        if (possibleDirections.isEmpty()) {
            this.getPossibleDirections();
        }
        this.directionIndex++;
        int size = possibleDirections.size();
        if (this.directionIndex <= size) {
            return possibleDirections.get(this.directionIndex - 1);
        } else if (size > 0) {
            return possibleDirections.get(size - 1);
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
        if (inCellBifurcation() || this.lastDirection == null) {
            generateRandomDirections();
        } else {
            getNoBifurcationDirections();
        }
    }

    protected boolean inCellBifurcation() {
        int unblockedCells = 0;
        ArrayList<Position> positions = getAllPossibleNextPositions();
        for (Position position : positions) {
            try {
                this.element.getStage().getCell(position).testPlaceElement();
                unblockedCells++;
            } catch (BlockedCellException | NoExistingCellException error) {
            }
        }
        if (unblockedCells >= bifurcationCells) {
            return true;
        }
        return false;
    }

    protected void generateRandomDirections() {
        ArrayList<Direction> directions = this.getAllDirections();
        while (!directions.isEmpty()) {
            int index = getRandomNumber(0, directions.size() - 1);
            this.possibleDirections.add(directions.remove(index));
        }
    }

    protected void getNoBifurcationDirections() {
        this.possibleDirections.add(this.lastDirection);
        this.possibleDirections.add(this.lastDirection.invert());
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
        ArrayList<Direction> directions = getAllDirections();
        for (Direction direction : directions) {
            positions.add(direction.getNewPosition(this.element.getPosition()));
        }
        return positions;
    }

    public int getNumberOfPossibleDirections() {
        return this.possibleDirections.size();
    }

}
