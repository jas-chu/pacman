package com.tdd.model.mocks;

import com.tdd.model.stageAbstractions.Item;
import com.tdd.model.stageAbstractions.Position;
import com.tdd.model.stageAbstractions.Stage;

public class MockItem extends Item {
	
	public boolean consumeMethodCalled = false;
	
	public MockItem() {
		super(null, new Position(0,0));
	}
	
	@Override
	public void consume() {
		this.consumeMethodCalled = true;
	}
	
	@Override
	public String getMapSerialization() {
		return "MockItem";
	}

}
