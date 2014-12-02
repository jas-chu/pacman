package com.tdd.model.states;

import com.tdd.model.mocks.MockProtagonist;
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
		this.angerWaitingCycles = new ArrayList<>();
		this.angerWaitingCycles.add(new Long(5));
		this.angerWaitingCycles.add(new Long(6));
		this.angerWaitingCycles.add(new Long(7));
		this.hunter = new Hunter(this.mockGhost, this.angerWaitingCycles);
		this.state = this.hunter;
	}

    @Test
    public void beEaten() {
		MockProtagonist anotherMockProtagonist = new MockProtagonist();
        this.state.beEaten(anotherMockProtagonist);
		assertTrue(anotherMockProtagonist.killMethodCalled);
		assertTrue(this.mockGhost.noMethodWasCalled());
    }
	
	@Test
    public void getAngerLevel() {
        assertEquals(this.hunter.getAngerLevel(), 0);
    }
	
	@Test
	public void increaseAnger() {
		this.hunter.increaseAnger();
		assertEquals(this.hunter.getAngerLevel(), 1);
		this.hunter.increaseAnger();
		assertEquals(this.hunter.getAngerLevel(), 2);
		this.hunter.increaseAnger();
		assertEquals(this.hunter.getAngerLevel(), 3);
	}
	
	@Test
	public void advanceCycle() {
		Long cycles = this.angerWaitingCycles.get(0);
		super.advanceCycle(cycles);
		assertEquals(this.hunter.getAngerLevel(), 1);
		
		cycles = this.angerWaitingCycles.get(1);
		super.advanceCycle(cycles);
		assertEquals(this.hunter.getAngerLevel(), 2);
		
		cycles = this.angerWaitingCycles.get(2);
		super.advanceCycle(cycles);
		assertEquals(this.hunter.getAngerLevel(), 3);
	}
	
	@Test
	public void collideWithProtagonist() {
		MockProtagonist mockProtagonist = new MockProtagonist();
		this.state.collideWithProtagonist(mockProtagonist);
		assertTrue(mockProtagonist.killMethodCalled);
		assertTrue(this.mockGhost.noMethodWasCalled());
	}
	
}
