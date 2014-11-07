package com.tdd.model.states;

import com.tdd.model.mocks.MockProtagonist;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public abstract class PassiveTest extends StateTest {
	
	protected int stateCycles;
	
	@Before
	@Override
	public void setUp() {
		super.setUp();
		this.stateCycles = 5;
	}
	
	@Test
	public void increaseAnger() {
		this.state.increaseAnger();
		assertTrue(this.mockGhost.noMethodWasCalled());
	}
	
	@Test
    public void beEaten() {
		MockProtagonist anotherMockProtagonist = new MockProtagonist();
        this.state.beEaten(anotherMockProtagonist);
		assertTrue(anotherMockProtagonist.noMethodWasCalled());
    }
	
	@Test
	public void advanceCycle() {
		super.advanceCycle(this.stateCycles);
		assertTrue(this.mockGhost.reviveMethodCalled);
	}
	
	@Test
	public void collideWithProtagonist() {
		MockProtagonist mockProtagonist = new MockProtagonist();
		this.state.collideWithProtagonist(mockProtagonist);
		assertTrue(mockProtagonist.noMethodWasCalled());
	}

}
