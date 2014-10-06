package com.tdd.model.stageAbstractions;

public abstract class Protagonist extends StageCharacter {

	public Protagonist(Stage givenStage, Position givenPosition) {
		super(givenStage, givenPosition);
	}
	
	public abstract boolean isAlive();
	public abstract void move(Direction dir);
	
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
	public void collideWithItem(Item givenItem) {
		givenItem.consume();
	}
}
