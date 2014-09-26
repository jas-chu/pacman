package com.tdd.model.stageAbstractions;

public abstract class StageCharacter extends StageElement {
	
	public StageCharacter(Position passedPosition) {
		super(passedPosition);
	}
	
    public abstract void kill();
    public abstract void revive();
	
}
