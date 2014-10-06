package com.tdd.model.stageAbstractions;

public abstract class Enemy extends StageCharacter {
	
	public Enemy(Stage givenStage, Position givenPosition) {
		super(givenStage, givenPosition);
	}
	
    public abstract void turnToPrey();

	public void move() {
		this.removeTeleportedState();
	}
	
	public abstract void advanceCycle();
	
	// COLLISIONS
	
	@Override
	public void collideWithElement(StageElement anotherElement) {
		anotherElement.collideWithEnemy(this);
	}

	@Override
	public void collideWithItem(Item givenItem) {
		// does nothing, allows functionality extension.
	}

	@Override
	public void collideWithEnemy(Enemy givenEnemy) {
		// does nothing, allows functionality extension.
	}
	
}
