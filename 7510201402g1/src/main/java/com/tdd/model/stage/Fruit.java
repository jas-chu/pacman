package com.tdd.model.stage;

import com.tdd.model.helpers.XMLConstants;
import com.tdd.model.stageAbstractions.MovingItem;
import com.tdd.model.stageAbstractions.Position;
import com.tdd.model.stageAbstractions.Stage;
import com.tdd.model.strategyFactory.RandomStrategyFactory;

public class Fruit extends MovingItem {
	
	private long hiddenCycles;
	private boolean hidden;
	
	public Fruit(Stage givenStage, Position givenPosition, int givenAwardingPoints, int givenSpeed, long givenHiddenCycles) {
		super(givenStage, givenPosition, givenAwardingPoints, new RandomStrategyFactory());
		this.setSpeed(givenSpeed);
		this.hiddenCycles = givenHiddenCycles;
		this.hidden = false;
	}

	@Override
	public int consume() {
		if (this.hidden) return 0;
		return super.consume();
	}
	
	@Override
	public String getMapSerialization() {
		return XMLConstants.FRUIT;
	}

}
