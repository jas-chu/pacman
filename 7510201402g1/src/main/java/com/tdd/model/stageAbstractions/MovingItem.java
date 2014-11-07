package com.tdd.model.stageAbstractions;

public abstract class MovingItem extends MovingElement implements Consumable {

	public MovingItem(Stage givenStage, Position givenPosition) {
		super(givenStage, givenPosition);
	}
	
	@Override
	public void collideWithElement(StageElement anotherElement) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void collideWithProtagonist(Protagonist givenProtagonist) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void collideWithConsumable(Consumable givenConsumable) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void collideWithEnemy(Enemy givenEnemy) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

}
