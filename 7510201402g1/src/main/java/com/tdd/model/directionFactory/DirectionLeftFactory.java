package com.tdd.model.directionFactory;

import com.tdd.model.direction.DirectionLeft;
import com.tdd.model.stageAbstractions.Direction;

public class DirectionLeftFactory extends DirectionFactory {

	@Override
	public Direction createDirection() {
		return new DirectionLeft();
	}

}