package com.tdd.controller.controllerAbstractions;

import com.tdd.model.exceptions.NoMoreMovementsException;
import com.tdd.model.stageAbstractions.Direction;
import com.tdd.model.stageAbstractions.Protagonist;

public abstract class PlayerController {
	
	protected Protagonist protagonist;
	protected Integer currentCycle;
	
	public PlayerController(Protagonist givenPacman) {
		this.currentCycle = 1;
		this.protagonist = givenPacman;
	}

	public void processMovement() throws NoMoreMovementsException {
		Direction dir = this.getNextDirection();
		this.protagonist.move(dir);
		this.advanceCycle();
	}
	
	private void advanceCycle() {
		this.currentCycle++;
	}
	
	protected abstract Direction getNextDirection() throws NoMoreMovementsException;
	
}
