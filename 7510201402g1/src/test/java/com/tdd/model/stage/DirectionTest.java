package com.tdd.model.stage;

import com.tdd.model.helpers.XMLConstants;
import com.tdd.model.stageAbstractions.Direction;
import com.tdd.model.stageAbstractions.Position;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class DirectionTest {
	
	Direction direction;
	
	@Before
	public void setUp() {
		this.direction = new Direction(XMLConstants.DIRECTION_RIGHT);
	}
	
	@Test
    public void getNewPositionTest() {
		Position firstPosition = new Position(0,0);
		Position nextPosition = new Position(1,0);
		assert(nextPosition.equals(this.direction.getNewPosition(firstPosition)));
	}
	
	@Test
	public void invertTest() {
		Direction invertedDir = new Direction(XMLConstants.DIRECTION_LEFT);
		assertEquals(this.direction.invert(), invertedDir);
	}
	
	@Test
	public void equalsTest(){
		Direction otherDir = new Direction(XMLConstants.DIRECTION_RIGHT);
		assertEquals(this.direction, otherDir);
	}
	
	@Test
	public void toStringTest() {
		assertEquals(this.direction.toString(), XMLConstants.DIRECTION_RIGHT);
	}

}