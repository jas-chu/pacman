package com.tdd.controller.controllerAbstractions;

import com.tdd.model.stage.Pacman;
import com.tdd.model.stageAbstractions.Direction;

public abstract class PlayerController {
	
	protected Pacman pacman;
	protected Integer currentCycle;
	
	public PlayerController(Pacman givenPacman) {
		this.currentCycle = 1;
		this.pacman = givenPacman;
	}

	public void processMovement() {
		Direction dir = this.getNextDirection();
		this.pacman.move(dir);
		this.advanceCycle();
	}
	
	private void advanceCycle() {
		this.currentCycle++;
	}
	
	protected abstract Direction getNextDirection();
	
}
