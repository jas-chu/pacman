package com.tdd.model.stage;

import com.tdd.model.stageAbstractions.Item;
import com.tdd.model.stageAbstractions.Position;
import com.tdd.model.stageAbstractions.Stage;

public class BigDot extends Item {

	public BigDot(Stage givenStage, Position givenPosition) {
		super(givenStage, givenPosition);
	}
	
	@Override
	public void consume() {
		super.consume();
		//this.stage.turnEnemiesToPrey();
	}
	
}
