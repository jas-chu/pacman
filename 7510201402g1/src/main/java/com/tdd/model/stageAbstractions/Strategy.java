package com.tdd.model.stageAbstractions;

import com.tdd.model.exceptions.BlockedCellException;
import com.tdd.model.exceptions.NoExistingCellException;
import com.tdd.model.helpers.RandomNumberGenerator;
import com.tdd.model.helpers.XMLConstants;
import com.tdd.model.stage.SquaredArea;
import java.util.ArrayList;
import java.util.List;

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
        if (this.directionIndex < possibleDirections.size()) {
            this.lastDirection = possibleDirections.get(this.directionIndex);
            return possibleDirections.get(this.directionIndex);
        } else {            
            return new Direction(XMLConstants.DIRECTION_RIGHT);
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
        List<Direction> directions = getBifurcationDirections();
        Position elementPosition = this.element.getPosition();
        for (Direction direction : directions) {
            try {
                this.element.getStage().getCell(elementPosition).getTargetPosition(direction);
				return true;
            } catch (BlockedCellException | NoExistingCellException ex) {
				// invalid direction, continue
            }
        }
        return false;
    }

    protected void generateRandomDirections() {
        ArrayList<Direction> directions = this.getAllDirections();
        while (!directions.isEmpty()) {
            int index = RandomNumberGenerator.getRandomNumber(0, directions.size() - 1);
            this.possibleDirections.add(directions.remove(index));
        }
    }
	
	protected List<Direction> getBifurcationDirections() {
		List<Direction> directions = this.getAllDirections();
		if (this.lastDirection != null) {
            directions.remove(this.lastDirection);
            directions.remove(this.lastDirection.invert());
        }
		return directions;
	}

    protected void getNoBifurcationDirections() {
        if (this.lastDirection != null) {
            this.possibleDirections.add(this.lastDirection);
            this.possibleDirections.add(this.lastDirection.invert());
        }
    }

    private ArrayList<Direction> getAllDirections() {
        ArrayList<Direction> directions = new ArrayList<>();
        directions.add(new Direction(XMLConstants.DIRECTION_LEFT));
        directions.add(new Direction(XMLConstants.DIRECTION_RIGHT));
        directions.add(new Direction(XMLConstants.DIRECTION_UP));
        directions.add(new Direction(XMLConstants.DIRECTION_DOWN));
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
