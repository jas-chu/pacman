package com.tdd.model.stageAbstractions;

import com.tdd.controller.controllerAbstractions.PlayerController;
import com.tdd.model.exceptions.BlockedCellException;
import com.tdd.model.exceptions.NoExistingCellException;
import com.tdd.model.exceptions.NoMoreMovementsException;

public abstract class Protagonist extends MovingElement {
	
	protected Integer score;
	protected boolean onStage;
	protected PlayerController controller;
	
	public Protagonist() {
        super(null, null);
		this.score = 0;
		this.onStage = false;
		this.controller = null;
    }
	
	public void placeOnStage(Stage givenStage, Position givenPosition) {
		this.stage = givenStage;
		this.setPosition(givenPosition);
		this.onStage = true;
	}
	
	public void removeFromStage() {
		this.stage = null;
		this.position = null;
		this.onStage = false;
	}
	
	public boolean isOnStage() {
		return this.onStage;
	}
	
	public abstract void kill();
    public abstract void revive();
    public abstract boolean isAlive();
    
	public void setController(PlayerController givenController) {
		this.controller = givenController;
	}
	
	@Override
	protected void moveOneTime() {
		if (!(this.isOnStage()) || this.controller == null) return;
		
		try {
			super.moveOneTime();
			Direction direction = this.controller.getNewDirection();
			Position nextPosition = direction.getNewPosition(this.position);
			try {
				this.stage.placeElement(nextPosition, this);
			} catch (BlockedCellException | NoExistingCellException error2) {
				// player hit wall
			}
			this.setSense(direction);
		} catch (NoMoreMovementsException error1) {
			// don't know where to move
		}
		
	}
	
	public Integer getScore() {
		return this.score;
	}
	
	// COLLISIONS
    @Override
    public void collideWithElement(StageElement anotherElement) {
		if (this.isOnStage()) {
			anotherElement.collideWithProtagonist(this);
		}
    }

    @Override
    public void collideWithProtagonist(Protagonist givenProtagonist) {
        // does nothing, allows functionality extension.
    }

    @Override
    public void collideWithEnemy(Enemy givenEnemy) {
		if (this.isOnStage()) {
			givenEnemy.collideWithProtagonist(this);
		}
    }

    @Override
    public void collideWithConsumable(Consumable givenConsumable) {
		if (this.isOnStage()) {
			givenConsumable.consume();
		}
    }
	
}
