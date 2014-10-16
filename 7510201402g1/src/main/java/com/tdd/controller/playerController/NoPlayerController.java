package com.tdd.controller.playerController;

import com.tdd.controller.controllerAbstractions.PlayerController;
import com.tdd.model.direction.DirectionRight;
import com.tdd.model.stageAbstractions.Direction;

public class NoPlayerController extends PlayerController {

	public NoPlayerController() {
		super(null);
	}
	
	@Override
	public void processMovement() {
		// no movement
	}
	
	@Override
	protected Direction getNextDirection() {
		return new DirectionRight();
	}

}
