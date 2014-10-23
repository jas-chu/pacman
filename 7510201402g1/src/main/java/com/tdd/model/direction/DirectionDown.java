package com.tdd.model.direction;

import com.tdd.model.helpers.XMLConstants;
import com.tdd.model.stageAbstractions.Direction;
import com.tdd.model.stageAbstractions.Position;

public class DirectionDown extends Direction {
        
	@Override
	public Position getNewPosition(Position position) {
		return position.createPositionAddingY(1);
	}

	@Override
	public Direction invert() {
		return new DirectionUp();
	}
        
    @Override        
	public String toString(){
		return XMLConstants.DIRECTION_DOWN;
	}
	
}
