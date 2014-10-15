package com.tdd.model.stage;

import com.tdd.model.mocks.MockGhost;
import com.tdd.model.mocks.MockStage;
import com.tdd.model.stageAbstractions.Item;
import com.tdd.model.stageAbstractions.Position;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class ItemTest {
	protected Item item;
	protected MockGhost ghost;
	protected Position position;
	protected MockStage stage;
	
	@Before
	public void setUp() {
		this.position = new Position(0, 0);
		this.stage = new MockStage();
		this.ghost = new MockGhost();
	}
	
	@Test
	public void isConsumed() {
		assertFalse(this.item.isConsumed());
	}
	
	@Test
	public void consume() {
		this.item.consume();
		assertTrue(this.item.isConsumed());
		assertTrue(this.stage.removeItemMethodCalled);
	}
	
	@Test
	public void collideWithElement() {
		this.item.collideWithElement(this.ghost);
		assertTrue(this.ghost.collideWithItemMethodCalled);
	}

	@Test
	public void collideWithEnemy() {
		this.item.collideWithEnemy(this.ghost);
		assertTrue(this.ghost.collideWithItemMethodCalled);
		assertFalse(this.item.isConsumed());
	}

	@Test
	public void collideWithItem() {
		this.item.collideWithItem(null);
		assertFalse(this.item.isConsumed());
	}

	@Test
	public void collideWithProtagonist() {
		this.item.collideWithProtagonist(null);
		assertTrue(this.item.isConsumed());
	}

}
