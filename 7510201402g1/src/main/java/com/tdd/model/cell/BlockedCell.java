package com.tdd.model.cell;

import com.tdd.model.exceptions.BlockedCellException;
import com.tdd.model.stageAbstractions.Cell;
import com.tdd.model.stageAbstractions.Position;
import com.tdd.model.stageAbstractions.StageElement;

public class BlockedCell extends Cell {

	public BlockedCell(int givenId, Position givenPosition) {
		super(givenId, givenPosition);
	}
	
	@Override
	public void testPlaceElement() throws BlockedCellException {
		throw new BlockedCellException();
	}
	
	@Override
	public void placeElement(StageElement element) {
		// blocked cell, allows functionality extension
	}

	@Override
	public void removeElement(StageElement element) {
		// blocked cell, allows functionality extension
	}

}
