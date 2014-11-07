package com.tdd.model.mocks;

import com.tdd.model.direction.DirectionRight;
import com.tdd.model.stageAbstractions.Strategy;
import com.tdd.model.stageAbstractions.Direction;


public class MockStrategy extends Strategy {
	
	public boolean getDirectionMethodCalled = false;
	public boolean advanceCycleMethodCalled = false;
	
	public MockStrategy() {
		super(null, 0);
	}
	
	@Override
	public Direction getDirection(){
		this.getDirectionMethodCalled = true;
        return new DirectionRight();
    }

	@Override
    public void advanceCycle(){
        this.advanceCycleMethodCalled = true;
    }

}
