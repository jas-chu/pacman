package com.tdd.model.directionFactory;

import com.tdd.model.direction.DirectionDown;
import com.tdd.model.stageAbstractions.Direction;

public class DirectionDownFactory extends DirectionFactory {

	@Override
	protected Direction createDirection() {
		return new DirectionDown();
	}

}