package com.tdd.model.stage;

import com.tdd.model.stage.Ghost;
import com.tdd.model.helpers.XMLConstants;
import com.tdd.model.mocks.MockProtagonist;
import com.tdd.model.mocks.MockState;
import com.tdd.model.mocks.MockStrategy;
import com.tdd.model.mocks.MockStateFactory;
import com.tdd.model.mocks.MockStrategyFactory;
import com.tdd.model.stageAbstractions.StageElement;
import com.tdd.model.stageAbstractions.StrategyFactory;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class GhostTest extends StageElementTest {
	
    private MockStateFactory factory;
    private MockState state;
    private MockStrategy strategy;
    private Ghost ghost;
    private MockProtagonist protagonist;
    private StrategyFactory strategyFactory;

    @Before
	@Override
    public void setUp() {
        this.factory = new MockStateFactory();
		this.strategyFactory = new MockStrategyFactory(XMLConstants.STRATEGY_NORMAL_SEARCHER);
		super.setUp();
		this.ghost = (Ghost) this.element;
        this.state = (MockState) ghost.getState();
		this.strategy = (MockStrategy) ghost.getStrategy();
        this.protagonist = new MockProtagonist();
    }
	
	@Override
	protected StageElement createElement() {
		return new Ghost(this.stage, this.position, this.factory, this.strategyFactory, 50, 1);
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
    public void collideWithElement() {
        this.ghost.collideWithElement(this.protagonist);
        assertEquals(this.state, this.ghost.getState());
        assertTrue(this.protagonist.collideWithEnemyMethodCalled);
    }

    @Test
    public void collideWithItem() {
        this.ghost.collideWithConsumable(null);
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
