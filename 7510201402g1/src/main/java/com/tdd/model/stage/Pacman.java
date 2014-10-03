package com.tdd.model.stage;

import com.tdd.model.stageAbstractions.Direction;
import com.tdd.model.stageAbstractions.StageCharacter;
import com.tdd.model.stageAbstractions.Position;
import com.tdd.model.stageAbstractions.Stage;

public class Pacman extends StageCharacter {
	
	private boolean alive;
	
	public Pacman(Stage givenStage, Position givenPosition) {
		super(givenStage, givenPosition);
	}
	
	@Override
	public void kill() {
		this.alive = false;
	}

	@Override
	public void revive() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	public boolean isAlive() {
		return this.alive;
	}
	
	public void move(Direction dir) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
}
