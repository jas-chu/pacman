package com.tdd.model.stageAbstractions;

public abstract class StageElement {
	
	protected Stage stage;
	protected Position position;
	
	public StageElement(Stage givenStage, Position passedPosition) {
		this.stage = givenStage;
		this.position = new Position(passedPosition);
	}
	
	public void setPosition(Position givenPosition) {
		this.position = new Position(givenPosition);
	}
	
	public boolean isInArea(Area area) {
		return area.positionIsWithinArea(this.position);
	}
	
}
