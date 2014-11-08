package com.tdd.controller.controllerAbstractions;

import com.tdd.model.exceptions.NoMoreMovementsException;
import com.tdd.model.stageAbstractions.Direction;

public interface PlayerController {
	
	public Direction getNewDirection() throws NoMoreMovementsException;
	
}
