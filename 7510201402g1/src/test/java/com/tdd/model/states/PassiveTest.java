package com.tdd.model.states;

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
		MockGhost anotherMockGhost = new MockGhost();
        this.state.beEaten(anotherMockGhost);
		assertTrue(anotherMockGhost.noMethodWasCalled());
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
