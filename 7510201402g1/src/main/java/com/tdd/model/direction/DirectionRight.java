package com.tdd.model.direction;

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
        
                
        /**
         * 
         * @return 
         */
        @Override        
        public String toString(){
            this.name = "right";
            return this.name;
        }
	
}
