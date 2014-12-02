package com.tdd.model.directionFactory;

import com.tdd.model.stageAbstractions.Direction;

public class DirectionFactory {
	
	private String direction;
	
	public DirectionFactory(String givenDirection) {
		this.direction = givenDirection;
	}
	
	public Direction createDirection() {
		return new Direction(direction);
	}
	
}
