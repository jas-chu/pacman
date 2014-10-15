package com.tdd.model.mocks;

import com.tdd.model.ghost.Ghost;
import com.tdd.model.ghost.State;
import com.tdd.model.ghost.StateFactory;

public class MockStateFactory extends StateFactory {
	
	public int hunterCreations = 0;
	public int deadCreations = 0;
	public int preyCreations = 0;
	
	public MockStateFactory() {
		super(null, 0, 0);
	}
	
	@Override
	public State createHunter(Ghost ghost) {
		this.hunterCreations++;
		return new MockState();
	}

	@Override
	public State createDead(Ghost ghost) {
		this.deadCreations++;
		return new MockState();
	}

	@Override
	public State createPrey(Ghost ghost) {
		this.preyCreations++;
		return new MockState();
	}
	
}
