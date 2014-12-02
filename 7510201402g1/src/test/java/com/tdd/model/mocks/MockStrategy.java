package com.tdd.model.mocks;

import com.tdd.model.helpers.XMLConstants;
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
        return new Direction(XMLConstants.DIRECTION_RIGHT);
    }

	@Override
    public void advanceCycle(){
        this.advanceCycleMethodCalled = true;
    }

}
