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
        super.moveOneTime();
        int i = Direction.getNumberOfPossibleDirections();
        while (i > 0) {
            Direction direction = this.getNextDirection();
            Position nextPosition = direction.getNewPosition(this.position);
            try {
                this.stage.placeElement(nextPosition, this);
				this.sense = direction;
                i = 0;
            } catch (BlockedCellException | NoExistingCellException error) {
                i--; // must look another way
            }
        }
        this.advanceMovementCycle();
    }
	
}
