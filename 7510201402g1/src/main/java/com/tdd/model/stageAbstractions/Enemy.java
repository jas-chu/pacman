package com.tdd.model.stageAbstractions;

public abstract class Enemy extends MovedByStrategy {

    private int awardingPoints;

    public Enemy(Stage givenStage, Position givenPosition, StrategyFactory givenStrategyFactory,
            int givenAwardingPoints, int givenSpeed) {
        super(givenStage, givenPosition, givenStrategyFactory, givenSpeed);
        this.awardingPoints = givenAwardingPoints;
    }

    public abstract void kill();

    public abstract void revive();

    public abstract void turnToPrey();
	public abstract void setAsPrey();
	public abstract void setAsHunter();
	
	public abstract Integer getId();
	public abstract State getState();
	
	public int getAwardingPoints() {
		return this.awardingPoints;
	}
	
    // COLLISIONS	
    @Override
    public void collideWithElement(StageElement anotherElement) {
        anotherElement.collideWithEnemy(this);
    }

    @Override
    public void collideWithConsumable(Consumable givenConsumable) {
        // does nothing, allows functionality extension.
    }

    @Override
    public void collideWithEnemy(Enemy givenEnemy) {
        // does nothing, allows functionality extension.
    }

}
