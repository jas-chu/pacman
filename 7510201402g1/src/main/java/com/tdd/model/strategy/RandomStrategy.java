package com.tdd.model.strategy;

import com.tdd.model.helpers.XMLConstants;
import com.tdd.model.stageAbstractions.Direction;
import com.tdd.model.stageAbstractions.MovedByStrategy;
import com.tdd.model.stageAbstractions.Strategy;

public class RandomStrategy extends Strategy {

    public RandomStrategy(MovedByStrategy givenElement) {
        super(givenElement, 0);
    }

    @Override
    public Direction getDirection() {
        if (possibleDirections.isEmpty() || this.lastDirection == null) {
            this.getRandomDirection();
            this.directionIndex = 0;
        }
        this.directionIndex++;
        if (this.directionIndex <= possibleDirections.size()) {
            this.lastDirection = possibleDirections.get(this.directionIndex - 1);
            return possibleDirections.get(this.directionIndex - 1);
        } else {
            return new Direction(XMLConstants.DIRECTION_RIGHT);
        }
    }

    @Override
    public void getRandomDirection() {
        if (inCellBifurcation()) {
            generateRandomDirections();
        } else {
            if (this.lastDirection != null) {
                this.possibleDirections.add(this.lastDirection);
            }
            getNoBifurcationDirections();
        }
    }

    @Override
    public void advanceCycle() {
        this.possibleDirections.clear();
        this.directionIndex = 0;
    }
}
