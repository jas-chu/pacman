package com.tdd.model.mocks;

import com.tdd.model.stageAbstractions.Direction;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.Position;
import com.tdd.model.stageAbstractions.Protagonist;

public class MockProtagonist extends Protagonist {
	
	public boolean isAliveMethodCalled = false;
	public boolean moveMethodCalled = false;
	public boolean killMethodCalled = false;
	public boolean reviveMethodCalled = false;
	public boolean collideWithEnemyMethodCalled = false;
	
	public MockProtagonist() {
		super(null, new Position(0,0));
	}

	@Override
	public boolean isAlive() {
		this.isAliveMethodCalled = true;
		return true;
	}

	@Override
	public void move(Direction dir) {
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
	public void collideWithEnemy(Enemy givenEnemy) {
		this.collideWithEnemyMethodCalled = true;
	}
	
	public boolean noMethodWasCalled() {
		return !(this.isAliveMethodCalled
		      || this.moveMethodCalled
			  || this.killMethodCalled
			  || this.reviveMethodCalled
			  || this.collideWithEnemyMethodCalled);
	}
	
}
