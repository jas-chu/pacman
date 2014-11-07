package com.tdd.model.stage;

import com.tdd.model.helpers.XMLConstants;
import com.tdd.model.stageAbstractions.StaticItem;
import com.tdd.model.stageAbstractions.Position;
import com.tdd.model.stageAbstractions.Stage;

public class Dot extends StaticItem {

	public Dot(Stage givenStage, Position givenPosition) {
		super(givenStage, givenPosition);
	}

	@Override
	public String getMapSerialization() {
		return XMLConstants.DOT;
	}
	
}
