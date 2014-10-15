package com.tdd.model.states;

import com.tdd.model.mocks.MockGhost;
import com.tdd.model.direction.DirectionRight;
import com.tdd.model.ghost.State;
import com.tdd.model.stageAbstractions.Direction;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public abstract class StateTest {
	protected MockGhost mockGhost;
	protected State state;
	
	@Before
	public void setUp() {
		this.mockGhost = new MockGhost();
	}
	
	@Test
	public void getDirection() {
		Direction direction = new DirectionRight();
		Direction otherDirection = this.state.getDirection(direction);
		assertEquals(direction.getClass(), otherDirection.getClass());
	}
	
	protected void advanceCycle(long cycles) {
		for (int i = 0; i < cycles - 1; ++i) {
			this.state.advanceCycle();
			assertTrue(this.mockGhost.noMethodWasCalled());
		}
		this.state.advanceCycle();
	}

}
