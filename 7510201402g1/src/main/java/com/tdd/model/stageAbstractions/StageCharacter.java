package com.tdd.model.stageAbstractions;

import com.tdd.model.exceptions.AlreadyTeleportedException;
import com.tdd.model.exceptions.BlockedCellException;

public abstract class StageCharacter extends StageElement {
	
	public StageCharacter(Stage givenStage, Position givenPosition) {
		super(givenStage, givenPosition);
	}
	
    public abstract void kill();
    public abstract void revive();
	
}
