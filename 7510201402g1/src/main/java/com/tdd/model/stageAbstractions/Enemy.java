package com.tdd.model.stageAbstractions;

import com.tdd.model.strategyFactory.StrategyFactory;

public abstract class Enemy extends MovedByStrategy {
    
    public Enemy(Stage givenStage, Position givenPosition, StrategyFactory givenStrategyFactory) {
        super(givenStage, givenPosition, givenStrategyFactory);
    }
	
	public abstract void kill();
    public abstract void revive();
	
    public abstract void turnToPrey();
	
	public abstract Integer getId();
	public abstract State getState();
	
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
