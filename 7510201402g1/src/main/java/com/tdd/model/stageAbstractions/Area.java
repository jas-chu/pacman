package com.tdd.model.stageAbstractions;

public abstract class Area {
	
	protected Position center;
	
	public Area(Position givenCenter) {
		this.center = new Position(givenCenter);
	}
	
	public abstract boolean positionIsWithinArea(Position position);
	
}