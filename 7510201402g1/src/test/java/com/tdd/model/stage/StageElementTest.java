package com.tdd.model.stage;

import com.tdd.model.mocks.MockProtagonist;
import com.tdd.model.mocks.MockStage;
import com.tdd.model.stageAbstractions.Area;
import com.tdd.model.stageAbstractions.Position;
import com.tdd.model.stageAbstractions.StageElement;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public abstract class StageElementTest {

    protected StageElement element;
	protected Position position;
	protected Position otherPosition;
	protected MockStage stage;
	
	@Before
	public void setUp() {
		this.position = new Position(0, 0);
		this.otherPosition = new Position(0, 1);
		this.stage = new MockStage();
		this.element = this.createElement();
	}
	
	protected abstract StageElement createElement();
	
	@Test
	public void getStageTest() {
		assertEquals(this.element.getStage(), this.stage);
	}
    
	@Test
	public void getPositionTest() {
		assert(this.position.equals(this.element.getPosition()));
	}
	
	@Test
	public void setPositionTest() {
		this.element.setPosition(this.otherPosition);
		assert(!(this.position.equals(this.element.getPosition())));
		assert(this.otherPosition.equals(this.element.getPosition()));
	}
	
	@Test
	public void isInAreaTrueTest() {
		this.areaTest(this.otherPosition, 3, true);
	}
	
	@Test
	public void isInAreaFalseTest() {
		this.areaTest(new Position(0,20), 1, false);
	}
	
	private void areaTest(Position pos, int distance, Boolean expectedResult) {
		Area area = new SquaredArea(pos, distance);
		assertEquals(this.element.isInArea(area), expectedResult);
	}
	
	@Test
	public void getProtagonist(){
		assert(this.element.getProtagonist() instanceof MockProtagonist);
	}
	
}