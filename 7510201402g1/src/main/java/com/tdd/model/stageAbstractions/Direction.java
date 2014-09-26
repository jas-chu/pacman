package com.tdd.model.stageAbstractions;

public abstract class Direction {
	
	public abstract int getNewPosition(Position position);
	public abstract Direction invert();
	
}
