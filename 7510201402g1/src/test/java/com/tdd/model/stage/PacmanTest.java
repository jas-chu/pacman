package com.tdd.model.stage;

import com.tdd.model.mocks.MockItem;
import com.tdd.model.direction.DirectionRight;
import com.tdd.model.exceptions.AlreadyTeleportedException;
import com.tdd.model.mocks.MockGhost;
import com.tdd.model.mocks.MockProtagonist;
import com.tdd.model.mocks.MockStage;
import com.tdd.model.stageAbstractions.Direction;
import com.tdd.model.stageAbstractions.Position;
import com.tdd.model.stageAbstractions.StageElement;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class PacmanTest {
	
	private Position position;
	private MockStage stage;
	private Pacman pacman;

	@Before
	public void setUp() {
		this.position = new Position(0, 0);
		this.stage = new MockStage();
		this.pacman = new Pacman(this.stage, this.position);
	}
	
	@Test
	public void isAlive() {
		assertTrue(this.pacman.isAlive());
	}
	
	@Test
	public void kill() {
		this.pacman.kill();
		assertFalse(this.pacman.isAlive());
	}

	@Test
	public void revive() {
		this.pacman.revive();
		assertTrue(this.pacman.isAlive());
		assertTrue(this.stage.placeProtagonistAtHomeMethodCalled);
	}
	
	@Test
	public void move() {
		Direction dir = new DirectionRight();
		this.pacman.move(dir);
		assertTrue(this.stage.placeElementMethodCalled);
		assertTrue(this.position.createPositionAddingX(1).equals(this.pacman.getPosition()));
	}
	
	@Test
	public void teleport() {
		try {
			Position teleportPosition = new Position (4,2);
			this.pacman.teleport(teleportPosition);
			assertTrue(this.stage.placeElementMethodCalled);
			assertTrue(teleportPosition.equals(this.pacman.getPosition()));
		} catch (AlreadyTeleportedException ex) {
			fail();
		}
	}
	
	@Test
	public void teleportLoop() {
		Position firstTeleportPosition = new Position (4,2);
		Position secondTeleportPosition = new Position (8,5);
		try {
			this.pacman.teleport(firstTeleportPosition);
		} catch (AlreadyTeleportedException ex) {
			fail();
		}
		
		try {
			this.pacman.teleport(secondTeleportPosition);
			fail();
		} catch (AlreadyTeleportedException ex) {
			assertTrue(firstTeleportPosition.equals(this.pacman.getPosition()));
		}
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
		MockItem item = new MockItem();
		this.pacman.collideWithItem(item);
		assertTrue(item.consumeMethodCalled);
	}
	
}
