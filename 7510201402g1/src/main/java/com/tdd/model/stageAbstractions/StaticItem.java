package com.tdd.model.stageAbstractions;

import java.util.List;

public abstract class StaticItem extends StageElement implements Consumable {

    private boolean consumed;
    private int awardingPoints;

    public StaticItem(Stage givenStage, Position givenPosition, int givenAwardingPoints) {
        super(givenStage, givenPosition);
        this.consumed = false;
        this.awardingPoints = givenAwardingPoints;
    }

    @Override
    public synchronized int consume() {
        this.consumed = true;
        this.stage.removeStaticItem(this);
        this.changeAndNotify();
        return this.awardingPoints;
    }

    @Override
    public synchronized boolean isConsumed() {
        return this.consumed;
    }

    @Override
    public synchronized void addToList(List<StaticItem> staticItems, List<MovingItem> movingItems) {
        staticItems.add(this);
    }

	// COLLISIONS
    @Override
    public synchronized void collideWithElement(StageElement anotherElement) {
        anotherElement.collideWithConsumable(this);
    }

    @Override
    public synchronized void collideWithProtagonist(Protagonist givenProtagonist) {
        int points = this.consume();
        if (givenProtagonist != null) {
            givenProtagonist.awardPoints(points);
        }
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
