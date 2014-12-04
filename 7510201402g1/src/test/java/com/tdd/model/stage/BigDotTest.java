package com.tdd.model.stage;

import com.tdd.model.stageAbstractions.StageElement;
import org.junit.Test;
import static org.junit.Assert.*;

public class BigDotTest extends ItemTest {
	
	@Test
	@Override
	public void consume() {
		super.consume();
		assertTrue(this.stage.turnEnemiesToPreyMethodCalled);
	}

	@Override
	protected StageElement createElement() {
		return new BigDot(this.stage, this.position, 15);
	}
	
}
