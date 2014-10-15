package com.tdd.model.ghost;

import com.tdd.model.mocks.MockProtagonist;
import com.tdd.model.mocks.MockState;
import com.tdd.model.mocks.MockStrategy;
import com.tdd.model.mocks.MockStage;
import com.tdd.model.mocks.MockStateFactory;
import com.tdd.model.stageAbstractions.Position;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class GhostTest {
	
	private Position position;
	private MockStateFactory factory;
	private MockState state;
	private MockStrategy strategy;
	private MockStage stage;
	private Ghost ghost;
	private MockProtagonist protagonist;

	@Before
	public void setUp() {
		this.position = new Position(0, 0);
		this.factory = new MockStateFactory();
		this.strategy = new MockStrategy();
		this.stage = new MockStage();
		this.ghost = new Ghost(this.stage, this.position, this.factory, this.strategy);
		this.state = (MockState) ghost.getState();
		this.protagonist = new MockProtagonist();
	}
	
    @Test
    public void createdAsHunter() {
        assertEquals(this.factory.hunterCreations, 1);
    }

    @Test
    public void kill() {
        this.ghost.kill();
        assertEquals(this.factory.deadCreations, 1);
		assertTrue(this.stage.placeEnemiesAtHomeMethodCalled);
    }

    @Test
    public void turnIntoPrey() {
        this.ghost.turnToPrey();
        assertEquals(this.factory.preyCreations, 1);
    }

    @Test
    public void reviveAsHunter() {
        this.ghost.kill();
        this.ghost.revive();
        assertEquals(this.factory.hunterCreations, 2);
    }
	
	@Test
    public void move() {
		this.ghost.move();
		assertTrue(this.strategy.getDirectionMethodCalled);
		assertTrue(this.state.getDirectionMethodCalled);
		assertTrue(this.stage.placeElementMethodCalled);
		assertTrue(this.position.createPositionAddingX(1).equals(this.ghost.getPosition()));
    }

    @Test
    public void advanceCycle() {
        this.ghost.advanceCycle();
        assertTrue(this.strategy.advanceCycleMethodCalled);
		assertTrue(this.state.advanceCycleMethodCalled);
    }
	
	@Test
	public void collideWithElement() {
		this.ghost.collideWithElement(this.protagonist);
		assertEquals(this.state, this.ghost.getState());
		assertTrue(this.protagonist.collideWithEnemyMethodCalled);
	}

	@Test
	public void collideWithItem() {
		this.ghost.collideWithItem(null);
		assertEquals(this.state, this.ghost.getState());
	}

	@Test
	public void collideWithEnemy() {
		this.ghost.collideWithEnemy(null);
		assertEquals(this.state, this.ghost.getState());
	}
	
	@Test
    public void collideWithProtagonist() {
		this.ghost.collideWithProtagonist(null);
		assertTrue(this.state.beEatenMethodCalled);
    }
	
}
