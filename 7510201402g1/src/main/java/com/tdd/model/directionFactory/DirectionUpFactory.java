package com.tdd.model.directionFactory;

import com.tdd.model.direction.DirectionUp;
import com.tdd.model.stageAbstractions.Direction;

public class DirectionUpFactory extends DirectionFactory {

	@Override
	protected Direction createDirection() {
		return new DirectionUp();
	}

}