package com.tdd.model.stage;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class BigDotTest extends ItemTest {
	
	@Before
	@Override
	public void setUp() {
		super.setUp();
		this.item = new BigDot(this.stage, this.position);
	}
	
	@Test
	@Override
	public void consume() {
		super.consume();
		assertTrue(this.stage.turnEnemiesToPreyMethodCalled);
	}
	
}
