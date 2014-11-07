package com.tdd.model.stage;

import com.tdd.model.stageAbstractions.MovingItem;
import com.tdd.model.stageAbstractions.Position;
import com.tdd.model.stageAbstractions.Stage;

public class Fruit extends MovingItem {

	public Fruit(Stage givenStage, Position givenPosition) {
		super(givenStage, givenPosition);
	}

	@Override
	public void consume() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public boolean isConsumed() {
		throw new UnsupportedOperationException("Not supported yet.");
	}

}
