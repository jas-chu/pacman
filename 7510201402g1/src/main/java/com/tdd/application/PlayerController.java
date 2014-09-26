package com.tdd.application;

import com.tdd.model.direction.DirectionRight;
import com.tdd.model.stage.Pacman;
import com.tdd.model.stageAbstractions.Direction;

public class PlayerController {
	
	private Pacman pacman;
	
	PlayerController(Pacman passedPacman) {
		this.pacman = passedPacman;
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	void processMovement() {
		Direction dir = new DirectionRight();
		this.pacman.move(dir);
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
}
