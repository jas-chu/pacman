package com.tdd.controller.playerController;

import com.tdd.controller.controllerAbstractions.PlayerController;
import com.tdd.model.exceptions.NoMoreMovementsException;
import com.tdd.model.stageAbstractions.Direction;

public class KeyboardPlayerController implements PlayerController {

	@Override
	public Direction getNewDirection() throws NoMoreMovementsException {
		throw new UnsupportedOperationException("Not supported yet.");
	}

}
