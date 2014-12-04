package com.tdd.model.stageAbstractions;

import java.util.Observable;

public abstract class StageElement extends Observable implements Collidable {
	
	protected Stage stage;
	protected Position position = null;
	
	public StageElement(Stage givenStage, Position givenPosition) {
		this.stage = givenStage;
		if (givenPosition != null) this.position = new Position(givenPosition);
	}
	       
	public synchronized Stage getStage(){
		return this.stage;
	}
        
	public synchronized Position getPosition() {
		return this.position;
	}
	
	public synchronized void setPosition(Position givenPosition) {
		this.position = new Position(givenPosition);
	}
	
	public synchronized boolean isInArea(Area area) {
		if (this.position == null) return false;
		return area.positionIsWithinArea(this.position);
	}
	
	public synchronized Protagonist getProtagonist(){
		if (this.stage == null) return null;
		return this.stage.getProtagonist();
	}

	public abstract String getMapSerialization();
	
	public synchronized void changeAndNotify() {
		this.setChanged();
		this.notifyObservers();
	}
}
