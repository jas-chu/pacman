package com.tdd.model.stage;

import com.tdd.model.stageAbstractions.StageElement;

public class DotTest extends ItemTest {
	
	@Override
	protected StageElement createElement() {
		return new Dot(this.stage, this.position, 5);
	}
	
}