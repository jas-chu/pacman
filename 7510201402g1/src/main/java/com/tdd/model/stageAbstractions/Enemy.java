package com.tdd.model.stageAbstractions;

public abstract class Enemy extends StageCharacter {
	
	public Enemy(Position passedPosition) {
		super(passedPosition);
	}
	
    public abstract void turnToPrey();

	public abstract void move();

}
