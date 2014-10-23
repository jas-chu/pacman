package com.tdd.model.direction;

import com.tdd.model.helpers.XMLConstants;
import com.tdd.model.stageAbstractions.Direction;
import com.tdd.model.stageAbstractions.Position;

public class DirectionUp extends Direction {

	@Override
	public Position getNewPosition(Position position) {
		return position.createPositionSubstractingY(1);
	}

	@Override
	public Direction invert() {
		return new DirectionDown();
	}
	        
    @Override        
	public String toString(){
		return XMLConstants.DIRECTION_UP;
	}
	
}
