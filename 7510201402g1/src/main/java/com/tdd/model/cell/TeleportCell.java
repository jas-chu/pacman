package com.tdd.model.cell;

import com.tdd.model.stageAbstractions.Cell;
import com.tdd.model.stageAbstractions.Position;
import com.tdd.model.stageAbstractions.StageElement;

public class TeleportCell extends Cell {

	public TeleportCell(int givenId, Position givenPosition) {
		super(givenId, givenPosition);
	}

	@Override
	public void placeElement(StageElement element) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

}
