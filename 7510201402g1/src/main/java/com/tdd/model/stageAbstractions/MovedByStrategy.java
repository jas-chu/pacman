package com.tdd.model.stageAbstractions;

import com.tdd.model.exceptions.BlockedCellException;
import com.tdd.model.exceptions.NoExistingCellException;

public abstract class MovedByStrategy extends MovingElement {

    private Strategy strategy;
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
            System.out.println("direccionSugerida: " + direction.toString());
            try {
                this.stage.placeElement(direction, this);
                this.sense = direction;                
                this.strategy.setLastDirection(direction);
                System.out.println("direccionMOVIDA: " + direction.toString());
                i = 0;
            } catch (BlockedCellException | NoExistingCellException error) {
                System.out.println("BLOCKED CELL EXCEPTION");
                this.strategy.nextDirection();
                i--; // must look another way
            }
        }
        this.advanceMovementCycle();
    }

}
