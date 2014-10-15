package com.tdd.model.stage;

import org.junit.Before;

public class DotTest extends ItemTest {
	
	@Before
	@Override
	public void setUp() {
		super.setUp();
		this.item = new Dot(this.stage, this.position);
	}
	
}