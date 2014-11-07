package com.tdd.model.stageAbstractions;

public abstract class StaticItem extends StageElement implements Consumable {
	
	private boolean consumed;
	
	public StaticItem(Stage givenStage, Position givenPosition) {
		super(givenStage, givenPosition);
		this.consumed = false;
	}

	@Override
	public void consume() {
		this.consumed = true;
		this.stage.removeItem(this);
	}
	
	@Override
	public boolean isConsumed() {
		return this.consumed;
	}
	
	// COLLISIONS
	
	@Override
	public void collideWithElement(StageElement anotherElement) {
		anotherElement.collideWithConsumable(this);
	}

	@Override
	public void collideWithProtagonist(Protagonist givenProtagonist) {
		this.consume();
	}

	@Override
	public void collideWithConsumable(com.tdd.model.stageAbstractions.Consumable givenConsumable) {
		// does nothing, allows functionality extension.
	}

	@Override
	public void collideWithEnemy(Enemy givenEnemy) {
		givenEnemy.collideWithConsumable(this);
	}
	
}
