package com.tdd.model.stage;

import com.tdd.model.mocks.MockStaticItem;
import com.tdd.model.mocks.MockController;
import com.tdd.model.mocks.MockGhost;
import com.tdd.model.mocks.MockProtagonist;
import com.tdd.model.stageAbstractions.StageElement;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PacmanTest extends StageElementTest {
	
	private MockController controller;
	private Pacman pacman;

	@Before
	@Override
	public void setUp() {
		super.setUp();
		this.controller = new MockController();
		this.pacman = (Pacman)this.element;
		this.pacman.placeOnStage(this.stage, this.position);
		this.pacman.setController(this.controller);
	}
	
	@Override
	protected StageElement createElement() {
		return new Pacman();
	}
	
	@Test
	public void isAlive() {
		assertTrue(this.pacman.isAlive());
	}
	
	@Test
	public void kill() {
		int lives = this.pacman.getLives();
		this.pacman.kill();
		assertTrue(lives - 1 == this.pacman.getLives());
	}

	@Test
	public void revive() {
		this.pacman.revive();
		assertTrue(this.pacman.isAlive());
		assertTrue(this.stage.placeProtagonistAtHomeMethodCalled);
	}
	
	@Test
	public void move() {
		this.pacman.move();
		assertTrue(this.stage.placeElementMethodCalled);
		assertTrue(this.controller.getNextPosition(this.position).equals(this.pacman.getPosition()));
	}
	
	@Test
	public void collideWithElement() {
		MockProtagonist protagonist = new MockProtagonist();
		this.pacman.collideWithElement(protagonist);
		assertTrue(protagonist.collideWithProtagonistMethodCalled);
	}

	@Test
	public void collideWithProtagonist() {
		MockProtagonist protagonist = new MockProtagonist();
		this.pacman.collideWithProtagonist(protagonist);
		assertTrue(protagonist.noMethodWasCalled());
	}

	@Test
	public void collideWithEnemy() {
		MockGhost ghost = new MockGhost();
		this.pacman.collideWithEnemy(ghost);
		assertTrue(ghost.collideWithProtagonistMethodCalled);
	}
	
	@Test
	public void collideWithItem() {
		MockStaticItem item = new MockStaticItem();
		this.pacman.collideWithConsumable(item);
		assertTrue(item.consumeMethodCalled);
	}
	
}
