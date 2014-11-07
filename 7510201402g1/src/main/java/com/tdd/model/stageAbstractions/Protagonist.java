package com.tdd.model.stageAbstractions;

import com.tdd.model.exceptions.BlockedCellException;
import com.tdd.model.exceptions.NoExistingCellException;

public abstract class Protagonist extends MovingElement {
	
	protected Integer score;
	
	public Protagonist(Stage givenStage, Position givenPosition) {
        super(givenStage, givenPosition);
		this.score = 0;
    }
	
	public abstract void kill();
    public abstract void revive();
    public abstract boolean isAlive();
    
	protected Direction getNextDirection() {
		throw new UnsupportedOperationException("Not supported yet.");
	}
	
	@Override
	protected void moveOneTime() {
		super.moveOneTime();
		Direction direction = this.getNextDirection();
		Position nextPosition = direction.getNewPosition(this.position);
		try {
			this.stage.placeElement(nextPosition, this);
		} catch (BlockedCellException | NoExistingCellException error) {
			// player hit wall
		}
		this.setSense(direction);
	}
	
	public Integer getScore() {
		return this.score;
	}
	
	public void move(Direction dir) {
		// DEPRECATED
		// TODO: ERASE AND REFACTOR OTHER CLASES
		throw new UnsupportedOperationException("DEPRECATED");
	}
	
	// COLLISIONS
    @Override
    public void collideWithElement(StageElement anotherElement) {
        anotherElement.collideWithProtagonist(this);
    }

    @Override
    public void collideWithProtagonist(Protagonist givenProtagonist) {
        // does nothing, allows functionality extension.
    }

    @Override
    public void collideWithEnemy(Enemy givenEnemy) {
        givenEnemy.collideWithProtagonist(this);
    }

    @Override
    public void collideWithConsumable(Consumable givenConsumable) {
        givenConsumable.consume();
    }
}
