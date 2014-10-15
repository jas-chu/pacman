package com.tdd.model.states;

import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.Position;
import com.tdd.model.stageAbstractions.Protagonist;

public class MockGhost extends Enemy {
	
	public boolean turnToPreyMethodCalled = false;
	public boolean advanceCycleMethodCalled = false;
	public boolean killMethodCalled = false;
	public boolean reviveMethodCalled = false;
	public boolean collideWithProtagonistMethodCalled = false;
	
	public MockGhost() {
		super(null, new Position(0,0));
	}

	@Override
	public void turnToPrey() {
		this.turnToPreyMethodCalled = true;
	}

	@Override
	public void advanceCycle() {
		this.advanceCycleMethodCalled = true;
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
	public void collideWithProtagonist(Protagonist givenProtagonist) {
		this.collideWithProtagonistMethodCalled = true;
	}
	
	public boolean noMethodWasCalled() {
		return !(this.advanceCycleMethodCalled
		      || this.collideWithProtagonistMethodCalled
			  || this.killMethodCalled
			  || this.reviveMethodCalled
			  || this.turnToPreyMethodCalled);
	}

}
