package com.tdd.model.stageAbstractions;

public abstract class Item extends StageElement {
	
	private boolean consumed;
	
	public Item(Stage givenStage, Position givenPosition) {
		super(givenStage, givenPosition);
		this.consumed = false;
	}

	public void consume() {
		this.consumed = true;
		this.stage.removeItem(this);
	}
	
	public boolean isConsumed() {
		return this.consumed;
	}
	
	// COLLISIONS
	
	@Override
	public void collideWithElement(StageElement anotherElement) {
		anotherElement.collideWithItem(this);
	}

	@Override
	public void collideWithProtagonist(Protagonist givenProtagonist) {
		this.consume();
	}

	@Override
	public void collideWithItem(Item givenItem) {
		// does nothing, allows functionality extension.
	}

	@Override
	public void collideWithEnemy(Enemy givenEnemy) {
		givenEnemy.collideWithItem(this);
	}
	
}
