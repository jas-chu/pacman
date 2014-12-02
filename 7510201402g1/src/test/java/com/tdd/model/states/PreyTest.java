package com.tdd.model.states;

import com.tdd.model.helpers.XMLConstants;
import com.tdd.model.stageAbstractions.Direction;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class PreyTest extends PassiveTest {
	
	@Before
	@Override
	public void setUp() {
		super.setUp();
		this.state = new Prey(this.mockGhost, this.stateCycles);
	}
	
	@Test
	@Override
    public void beEaten() {
		super.beEaten();
		assertTrue(this.mockGhost.killMethodCalled);
    }
	
	@Test
	@Override
	public void collideWithProtagonist() {
		super.collideWithProtagonist();
		assertTrue(this.mockGhost.killMethodCalled);
	}
	
	@Test
	@Override
	public void getDirection() {
		Direction direction = new Direction(XMLConstants.DIRECTION_RIGHT);
		Direction otherDirection = this.state.getDirection(direction);
		Direction expectedDirection = direction.invert();
		assertEquals(expectedDirection.getClass(), otherDirection.getClass());
	}

}
