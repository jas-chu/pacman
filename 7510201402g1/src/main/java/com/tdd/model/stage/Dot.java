package com.tdd.model.stage;

import com.tdd.model.helpers.XMLConstants;
import com.tdd.model.stageAbstractions.StaticItem;
import com.tdd.model.stageAbstractions.Position;
import com.tdd.model.stageAbstractions.Stage;

public class Dot extends StaticItem {

	public Dot(Stage givenStage, Position givenPosition, int givenAwardingPoints) {
		super(givenStage, givenPosition, givenAwardingPoints);
	}

	@Override
	public String getMapSerialization() {
		return XMLConstants.DOT;
	}
	
}
