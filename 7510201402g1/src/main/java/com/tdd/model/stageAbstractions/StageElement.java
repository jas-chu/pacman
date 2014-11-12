package com.tdd.model.stageAbstractions;

import com.tdd.model.exceptions.AlreadyTeleportedException;
import com.tdd.model.exceptions.BlockedCellException;
import com.tdd.model.exceptions.NoExistingCellException;
import java.util.Observable;

public abstract class StageElement extends Observable implements Collidable {
	
	protected Stage stage;
	protected Position position = null;
	private boolean teleported;
	
	public StageElement(Stage givenStage, Position givenPosition) {
		this.stage = givenStage;
		if (givenPosition != null) this.position = new Position(givenPosition);
		this.teleported = false;
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
		if (this.position == null) return false;
		return area.positionIsWithinArea(this.position);
	}
	
	public void teleport(Position givenPosition) throws AlreadyTeleportedException {
		if (this.stage == null) return;
		this.testTeleport();
		try {
			this.teleported = true;
			this.stage.placeElement(givenPosition, this);
		} catch (BlockedCellException | NoExistingCellException ex) {
			// can't teleport to blocked or non-existing cell
		}
	}
	
	private void testTeleport() throws AlreadyTeleportedException {
		if (this.teleported) throw new AlreadyTeleportedException();
	}
	
	protected void removeTeleportedState() {
		this.teleported = false;
	}
	
	public Protagonist getProtagonist(){
		if (this.stage == null) return null;
		return this.stage.getProtagonist();
	}

	public abstract String getMapSerialization();
	
}
