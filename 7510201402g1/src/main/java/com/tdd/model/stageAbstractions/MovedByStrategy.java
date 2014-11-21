package com.tdd.model.stageAbstractions;

import com.tdd.model.exceptions.BlockedCellException;
import com.tdd.model.exceptions.NoExistingCellException;

public abstract class MovedByStrategy extends MovingElement {

    protected Strategy strategy;
    private StrategyFactory strategyFactory;

    public MovedByStrategy(Stage givenStage, Position givenPosition, StrategyFactory givenStrategy, int givenSpeed) {
        super(givenStage, givenPosition, givenSpeed);
        this.strategyFactory = givenStrategy;
        this.strategy = this.strategyFactory.getStrategy(this);
    }

    public Strategy getStrategy() {
        return this.strategy;
    }

    public void advanceMovementCycle() {
        this.strategy.advanceCycle();
    }

    protected Direction getNextDirection() {
        return this.strategy.getDirection();
    }

    @Override
    public void moveOneTime() {
        int i = Direction.getNumberOfPossibleDirections();
        while (i > 0) {
            Direction direction = this.getNextDirection();                        
            try {
                this.stage.placeElement(direction, this);
                this.sense = direction;                
                this.strategy.setLastDirection(direction);                
                i = 0;
            } catch (BlockedCellException | NoExistingCellException error) {                
                this.strategy.nextDirection();
                i--; // must look another way
            }
        }
        this.advanceMovementCycle();
    }

}
