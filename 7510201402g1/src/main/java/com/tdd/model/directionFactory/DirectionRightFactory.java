package com.tdd.model.directionFactory;

import com.tdd.model.direction.DirectionRight;
import com.tdd.model.stageAbstractions.Direction;

public class DirectionRightFactory extends DirectionFactory {

	@Override
	public Direction createDirection() {
		return new DirectionRight();
	}

}