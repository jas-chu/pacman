package com.tdd.model.mocks;

import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.State;
import com.tdd.model.states.StateFactory;

public class MockStateFactory extends StateFactory {
	
	public int hunterCreations = 0;
	public int deadCreations = 0;
	public int preyCreations = 0;
	
	public MockStateFactory() {
		super(null, 0, 0);
	}
	
	@Override
	public State createHunter(Enemy givenEnemy) {
		this.hunterCreations++;
		return new MockState();
	}

	@Override
	public State createDead(Enemy givenEnemy) {
		this.deadCreations++;
		return new MockState();
	}

	@Override
	public State createPrey(Enemy givenEnemy) {
		this.preyCreations++;
		return new MockState();
	}
	
}
