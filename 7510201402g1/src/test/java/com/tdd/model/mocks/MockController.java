package com.tdd.model.mocks;

import com.tdd.controller.controllerAbstractions.PlayerController;
import com.tdd.model.direction.DirectionRight;
import com.tdd.model.exceptions.NoMoreMovementsException;
import com.tdd.model.stageAbstractions.Direction;
import com.tdd.model.stageAbstractions.Position;

public class MockController implements PlayerController {

	@Override
	public Direction getNewDirection() throws NoMoreMovementsException {
		return new DirectionRight();
	}
	
	public Position getNextPosition(Position oldPosition) {
		return oldPosition.createPositionAddingX(1);
	}

}
