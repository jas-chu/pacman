package com.tdd.model.stageAbstractions;

public abstract class StageElement {
	
	protected Position position;
	
	public StageElement(Position passedPosition) {
		this.position = new Position(passedPosition);
	}

	public boolean isInArea(SquaredArea area) {
		return area.positionIsWithinArea(this.position);
	}
	
}
