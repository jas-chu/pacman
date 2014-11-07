package com.tdd.model.stageAbstractions;

import com.tdd.model.exceptions.BlockedCellException;
import com.tdd.model.exceptions.NoExistingCellException;
import com.tdd.model.strategyFactory.StrategyFactory;

public abstract class MovedByStrategy extends MovingElement {
	
	private Strategy strategy;
    private StrategyFactory strategyFactory;
	
	public MovedByStrategy(Stage givenStage, Position givenPosition, StrategyFactory givenStrategy) {
		super(givenStage, givenPosition);
		this.strategyFactory = givenStrategy;
		this.strategy = this.strategyFactory.getStrategy(this);
	}
	
	public Strategy getStrategy() {
        return this.strategy;
    }
	
	public void advanceCycle() {
        this.strategy.advanceCycle();
    }
	
	protected abstract Direction finishProcessingDirection(Direction givenDirection);
	
	@Override
    public void move() {
        super.move();
        int i = 4; // four possible directions
        while (i > 0) {
            Direction firstDirection = this.strategy.getDirection();
            i = this.strategy.getNumberOfPossibleDirections();
            Direction finalDirection = this.finishProcessingDirection(firstDirection);
            Position nextPosition = finalDirection.getNewPosition(this.position);
            try {
                this.stage.placeElement(nextPosition, this);
				this.sense = finalDirection;
                i = 0;
            } catch (BlockedCellException | NoExistingCellException error) {
                i--; // must look another way
            }
        }
        this.advanceCycle();
    }
	
}
