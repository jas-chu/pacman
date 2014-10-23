package com.tdd.model.direction;

import com.tdd.model.helpers.XMLConstants;
import com.tdd.model.stageAbstractions.Direction;
import com.tdd.model.stageAbstractions.Position;

public class DirectionRight extends Direction {

	@Override
	public Position getNewPosition(Position position) {
		return position.createPositionAddingX(1);
	}
        
	@Override
	public Direction invert() {
		return new DirectionLeft();
	}
        
    @Override        
	public String toString(){
		return XMLConstants.DIRECTION_RIGHT;
	}
	
}
