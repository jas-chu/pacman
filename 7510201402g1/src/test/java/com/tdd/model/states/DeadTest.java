package com.tdd.model.states;

import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class DeadTest extends PassiveTest {
	
	@Before
	@Override
	public void setUp() {
		super.setUp();
		this.state = new Dead(this.mockGhost, this.stateCycles);
	}
	
	@Test
	@Override
    public void beEaten() {
		super.beEaten();
		assertTrue(this.mockGhost.noMethodWasCalled());
    }
	
	@Test
	@Override
	public void collideWithProtagonist() {
		super.collideWithProtagonist();
		assertTrue(this.mockGhost.noMethodWasCalled());
	}
	
}
