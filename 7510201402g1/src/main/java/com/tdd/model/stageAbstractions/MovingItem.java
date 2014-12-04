package com.tdd.model.stageAbstractions;

import java.util.List;

public abstract class MovingItem extends MovedByStrategy implements Consumable {

    protected boolean consumed;
    protected int awardingPoints;

    public MovingItem(Stage givenStage, Position givenPosition, int givenAwardingPoints,
            StrategyFactory givenStrategyFactory, int givenSpeed) {
        super(givenStage, givenPosition, givenStrategyFactory, givenSpeed);
        this.consumed = false;
        this.awardingPoints = givenAwardingPoints;
    }

    @Override
    public synchronized int consume() {
        this.consumed = true;
        this.stage.removeMovingItem(this);
        return this.awardingPoints;
    }

    @Override
    public synchronized boolean isConsumed() {
        return this.consumed;
    }

    @Override
    public synchronized void addToList(List<StaticItem> staticItems, List<MovingItem> movingItems) {
        movingItems.add(this);
    }

	// COLLISIONS
    @Override
    public synchronized void collideWithElement(StageElement anotherElement) {
        anotherElement.collideWithConsumable(this);
    }

    @Override
    public synchronized void collideWithProtagonist(Protagonist givenProtagonist) {        
        int points = this.consume();
        givenProtagonist.awardPoints(points);
    }

    @Override
    public synchronized void collideWithConsumable(Consumable givenConsumable) {
        // does nothing, allows functionality extension.
    }

    @Override
    public synchronized void collideWithEnemy(Enemy givenEnemy) {
        givenEnemy.collideWithConsumable(this);
    }

}
