package com.tdd.model.stageAbstractions;

import com.tdd.model.exceptions.AlreadyTeleportedException;
import com.tdd.model.exceptions.BlockedCellException;

public abstract class StageElement implements Collidable {
	
	protected Stage stage;
	protected Position position;
	private boolean teleported;
	
	public StageElement(Stage givenStage, Position passedPosition) {
		this.stage = givenStage;
		this.position = new Position(passedPosition);
		this.removeTeleportedState();
	}
	       
        public Stage getStage(){
            return this.stage;
        }
        
	public Position getPosition() {
		return this.position;
	}
	
	public void setPosition(Position givenPosition) {
		this.position = new Position(givenPosition);
	}
	
	public boolean isInArea(Area area) {
		return area.positionIsWithinArea(this.position);
	}
	
	public void teleport(Position givenPosition) throws AlreadyTeleportedException {
		this.testTeleport();
		try {
			this.teleported = true;
			this.stage.placeElement(givenPosition, this);
		} catch (BlockedCellException ex) {
			// can't teleport to blocked cell
		}
	}
	
	private void testTeleport() throws AlreadyTeleportedException {
		if (this.teleported) throw new AlreadyTeleportedException();
	}
	
	protected void removeTeleportedState() {
		this.teleported = false;
	}
	
	public Protagonist getProtagonist(){
		return this.stage.getProtagonist();
	}

	public abstract String getMapSerialization();
	
}
