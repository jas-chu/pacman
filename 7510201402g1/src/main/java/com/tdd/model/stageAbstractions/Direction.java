package com.tdd.model.stageAbstractions;

public abstract class Direction {
	
	public abstract Position getNewPosition(Position position);
	public abstract Direction invert();
	
}
