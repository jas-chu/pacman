package com.tdd.model.stageAbstractions;

import com.tdd.model.exceptions.AlreadyTeleportedException;
import com.tdd.model.exceptions.BlockedCellException;

public abstract class StageCharacter extends StageElement {
	
	private boolean teleported;
	
	public StageCharacter(Stage givenStage, Position givenPosition) {
		super(givenStage, givenPosition);
		this.removeTeleportedState();
	}
	
    public abstract void kill();
    public abstract void revive();
	
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
	
}
