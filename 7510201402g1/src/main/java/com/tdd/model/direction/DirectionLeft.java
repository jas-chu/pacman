package com.tdd.model.direction;

import com.tdd.model.stageAbstractions.Direction;
import com.tdd.model.stageAbstractions.Position;

public class DirectionLeft extends Direction {

	@Override
	public Position getNewPosition(Position position) {
		return position.createPositionSubstractingX(1);
	}

	@Override
	public Direction invert() {
		return new DirectionRight();
	}
	        
        /**
         * 
         * @return 
         */
        @Override        
        public String toString(){
            this.name = "left";
            return this.name;
        }
}
