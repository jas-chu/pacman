package com.tdd.model.stageAbstractions;

public abstract class Direction {
	protected String name;
	public abstract Position getNewPosition(Position position);
	public abstract Direction invert();
}
