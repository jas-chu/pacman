package com.tdd.model.mocks;

import com.tdd.model.stageAbstractions.StaticItem;
import com.tdd.model.stageAbstractions.Position;

public class MockStaticItem extends StaticItem {
	
	public boolean consumeMethodCalled = false;
	
	public MockStaticItem() {
		super(null, new Position(0,0), 5);
	}
	
	@Override
	public int consume() {
		this.consumeMethodCalled = true;
		return 5;
	}
	
	@Override
	public String getMapSerialization() {
		return "MockStaticItem";
	}

}
