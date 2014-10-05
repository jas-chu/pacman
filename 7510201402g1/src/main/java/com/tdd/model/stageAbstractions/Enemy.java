package com.tdd.model.stageAbstractions;

public abstract class Enemy extends StageCharacter {
	
	public Enemy(Stage givenStage, Position givenPosition) {
		super(givenStage, givenPosition);
	}
	
    public abstract void turnToPrey();

	public void move() {
		this.removeTeleportedState();
	}
	
	public abstract void advanceCycle();
	
}
