package com.tdd.model.stageAbstractions;

public abstract class Protagonist extends MovingElement {
	
	protected Integer score;
	
	public Protagonist(Stage givenStage, Position givenPosition) {
        super(givenStage, givenPosition);
		this.score = 0;
    }
	
	public abstract void kill();
    public abstract void revive();
	
    public abstract boolean isAlive();
    public abstract void move(Direction dir);
	
	public Integer getScore() {
		return this.score;
	}
	
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
    public void collideWithConsumable(Consumable givenConsumable) {
        givenConsumable.consume();
    }
}
