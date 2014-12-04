package com.tdd.model.stage;

import com.tdd.model.mocks.MockGhost;
import com.tdd.model.stageAbstractions.StaticItem;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public abstract class ItemTest extends StageElementTest {
	
	protected StaticItem item;
	protected MockGhost ghost;
	
	@Before
	@Override
	public void setUp() {
		super.setUp();
		this.ghost = new MockGhost();
		this.item = (StaticItem)this.element;
	}
	
	@Test
	public void isConsumed() {
		assertFalse(this.item.isConsumed());
	}
	
	@Test
	public void consume() {
		this.item.consume();
		assertTrue(this.item.isConsumed());
		assertTrue(this.stage.removeStaticItemMethodCalled);
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
		this.item.collideWithConsumable(null);
		assertFalse(this.item.isConsumed());
	}

	@Test
	public void collideWithProtagonist() {
		this.item.collideWithProtagonist(null);
		assertTrue(this.item.isConsumed());
	}

}
