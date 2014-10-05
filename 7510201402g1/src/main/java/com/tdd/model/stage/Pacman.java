package com.tdd.model.stage;

import com.tdd.model.exceptions.BlockedCellException;
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
		this.alive = true;
		this.stage.placePacmanAtHome(this);
	}

	public boolean isAlive() {
		return this.alive;
	}
	
	public void move(Direction dir) {
		this.removeTeleportedState();
		Position nextPosition = dir.getNewPosition(this.position);
		try {
			this.stage.placeElement(nextPosition, this);
		} catch (BlockedCellException error) {
			// player hit wall
		}
	}
	
}
