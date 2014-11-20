package com.tdd.model.strategy;

import com.tdd.model.direction.DirectionRight;
import com.tdd.model.stageAbstractions.Direction;
import com.tdd.model.stageAbstractions.MovedByStrategy;
import com.tdd.model.stageAbstractions.Strategy;

public class RandomStrategy extends Strategy {

    public RandomStrategy(MovedByStrategy givenElement) {
        super(givenElement, 0);
    }

    @Override
    public Direction getDirection() {        
        if (possibleDirections.isEmpty()) {
            this.getRandomDirection();
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

    @Override
    public void getRandomDirection() {
        if (inCellBifurcation()) {
            generateRandomDirections();
        } else {
            getNoBifurcationDirections();
        }
    }

    @Override
    public void advanceCycle() {
        this.possibleDirections.clear();
        this.directionIndex = 0;

    }
}
