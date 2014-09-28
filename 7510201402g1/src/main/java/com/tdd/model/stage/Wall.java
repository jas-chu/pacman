package com.tdd.model.stage;

import com.tdd.model.stageAbstractions.StageElement;
import com.tdd.model.stageAbstractions.Position;
import com.tdd.model.stageAbstractions.Stage;

public class Wall extends StageElement {

	public Wall(Stage givenStage, Position givenPosition) {
		super(givenStage, givenPosition);
	}
	
}
