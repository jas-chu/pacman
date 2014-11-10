package com.tdd.model.stageAbstractions;

import java.util.List;

public abstract class MovingItem extends MovedByStrategy implements Consumable {
	
	private boolean consumed;
	private int awardingPoints;
	
	public MovingItem(Stage givenStage, Position givenPosition, int givenAwardingPoints, StrategyFactory givenStrategyFactory) {
		super(givenStage, givenPosition, givenStrategyFactory);
		this.consumed = false;
		this.awardingPoints = givenAwardingPoints;
	}

	@Override
	public int consume() {
		this.consumed = true;
		this.stage.removeMovingItem(this);
		return this.awardingPoints;
	}
	
	@Override
	public boolean isConsumed() {
		return this.consumed;
	}
	
	@Override
	public int getAwardingPoints() {
		return this.awardingPoints;
	}
	
	@Override
	public void addToList(List<StaticItem> staticItems, List<MovingItem> movingItems) {
		movingItems.add(this);
	}
	
	// COLLISIONS
	
	@Override
	public void collideWithElement(StageElement anotherElement) {
		anotherElement.collideWithConsumable(this);
	}

	@Override
	public void collideWithProtagonist(Protagonist givenProtagonist) {
		int points = this.consume();
		givenProtagonist.awardPoints(points);
	}

	@Override
	public void collideWithConsumable(Consumable givenConsumable) {
		// does nothing, allows functionality extension.
	}

	@Override
	public void collideWithEnemy(Enemy givenEnemy) {
		givenEnemy.collideWithConsumable(this);
	}

}
