package com.tdd.model.stage;

import com.tdd.model.stageAbstractions.Area;
import com.tdd.model.stageAbstractions.Position;
import org.junit.Test;

public class SquaredAreaTest {
	
	private Area createArea() {
		Position position = new Position(5,7);
		return new SquaredArea(position, 3);
	}
	
    @Test
	public void creationTest() {
		Area area = this.createArea();
		assert(area != null);
	}
	
	@Test
	public void isWithinAreaTrueTest() {
		this.isWithinAreaTest(new Position(4,6), true);
	}
	
	@Test
	public void isWithinAreaFalseTest() {
		this.isWithinAreaTest(new Position(20,20), false);
	}
	
	private void isWithinAreaTest(Position position, Boolean expectedResult) {
		Area area = this.createArea();
		assert(area.positionIsWithinArea(position) == expectedResult);
	}

}