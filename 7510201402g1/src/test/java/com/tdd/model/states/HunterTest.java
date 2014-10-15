package com.tdd.model.states;

import java.util.ArrayList;
import java.util.List;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class HunterTest extends StateTest {
	
	private List<Long> angerWaitingCycles;
	private Hunter hunter;
	
	@Before
	@Override
	public void setUp() {
		super.setUp();
		this.angerWaitingCycles = new ArrayList<Long>();
		this.angerWaitingCycles.add(new Long(5));
		this.angerWaitingCycles.add(new Long(6));
		this.angerWaitingCycles.add(new Long(7));
		this.hunter = new Hunter(this.mockGhost, this.angerWaitingCycles);
		this.state = this.hunter;
	}

    @Test
    public void beEaten() {
		MockGhost anotherMockGhost = new MockGhost();
        this.state.beEaten(anotherMockGhost);
		assertTrue(anotherMockGhost.killMethodCalled);
		assertTrue(this.mockGhost.noMethodWasCalled());
    }
	
	@Test
    public void getAngerLevel() {
        assertTrue(this.hunter.getAngerLevel() == 0);
    }
	
	@Test
	public void increaseAnger() {
		int i = 0;
		for ( ; i < this.angerWaitingCycles.size() ; ++i) {
			assertTrue(this.hunter.getAngerLevel() == i);
			this.hunter.increaseAnger();
		}
		assertTrue(this.hunter.getAngerLevel() == i);
	}
	
	@Test
	public void advanceCycle() {
		for (int i = 0; i < this.angerWaitingCycles.size() - 1; ++i) {
			Long cycles = this.angerWaitingCycles.get(i);
			super.advanceCycle(cycles);
			assertTrue(this.hunter.getAngerLevel() == i+1);
		}
	}
	
	@Test
	public void collideWithProtagonist() {
		MockProtagonist mockProtagonist = new MockProtagonist();
		this.state.collideWithProtagonist(mockProtagonist);
		assertTrue(mockProtagonist.killMethodCalled);
		assertTrue(this.mockGhost.noMethodWasCalled());
	}
	
}
