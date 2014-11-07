package com.tdd.model.stageAbstractions;

public abstract class Direction {

	public static int getNumberOfPossibleDirections() {
		return 4;
	}
	
	public abstract Position getNewPosition(Position position);
	public abstract Direction invert();
}
