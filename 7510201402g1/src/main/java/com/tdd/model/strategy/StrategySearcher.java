package com.tdd.model.strategy;

import com.tdd.model.stageAbstractions.Direction;
import com.tdd.model.ghost.Strategy;
import com.tdd.model.stageAbstractions.Enemy;

public class StrategySearcher extends Strategy {

	public StrategySearcher(Enemy givenEnemy) {
		super(givenEnemy);
	}

	@Override
	public void advanceCycle() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
        
        @Override
        public Direction getRandomDirection(){
            throw new UnsupportedOperationException("Not supported yet.");            
        }
        
        @Override
        public Direction chasePacman(){
            throw new UnsupportedOperationException("Not supported yet.");
        }
	
}
