package com.tdd.model.mocks;

import com.tdd.model.exceptions.AlreadyTeleportedException;
import com.tdd.model.stageAbstractions.Area;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.Position;
import com.tdd.model.stageAbstractions.Protagonist;

public class MockProtagonist extends Protagonist {
	
	public boolean isInArea = false;
	public boolean isAliveMethodCalled = false;
	public boolean moveMethodCalled = false;
	public boolean killMethodCalled = false;
	public boolean reviveMethodCalled = false;
	public boolean teleportMethodCalled = false;
	public boolean collideWithProtagonistMethodCalled = false;
	public boolean collideWithEnemyMethodCalled = false;
	public boolean collideWithItemMethodCalled = false;
	
	public MockProtagonist() {
		super();
	}

	@Override
	public boolean isAlive() {
		this.isAliveMethodCalled = true;
		return true;
	}

	@Override
	public void move() {
		this.moveMethodCalled = true;
	}

	@Override
	public void kill() {
		this.killMethodCalled = true;
	}

	@Override
	public void revive() {
		this.reviveMethodCalled = true;
	}
	
	@Override
	public void teleport(Position givenPosition) throws AlreadyTeleportedException {
		this.teleportMethodCalled = true;
	}
	
	@Override
	public void collideWithProtagonist(Protagonist givenProtagonist) {
		this.collideWithProtagonistMethodCalled = true;
	}
	
	@Override
	public void collideWithEnemy(Enemy givenEnemy) {
		this.collideWithEnemyMethodCalled = true;
	}
	
	@Override
	public void collideWithConsumable(com.tdd.model.stageAbstractions.Consumable givenConsumable) {
		this.collideWithItemMethodCalled = true;
	}
	
	public boolean noMethodWasCalled() {
		return !(this.isAliveMethodCalled
		      || this.moveMethodCalled
			  || this.killMethodCalled
			  || this.reviveMethodCalled
			  || this.teleportMethodCalled
			  || this.collideWithProtagonistMethodCalled
			  || this.collideWithEnemyMethodCalled
			  || this.collideWithItemMethodCalled);
	}
	
	@Override
	public boolean isInArea(Area area){
		return this.isInArea;
	}

	public void setIsInArea(boolean isInArea){
		this.isInArea = isInArea;
	}

}
