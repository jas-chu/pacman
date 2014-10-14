package com.tdd.model.cell.cellBuilding;

import com.tdd.model.cell.ClearCell;
import com.tdd.model.exceptions.NotMyJobException;
import com.tdd.model.stageAbstractions.Cell;
import com.tdd.model.stageAbstractions.Position;

/**
 *
 * 
 */
public class ClearCellFactory implements CellFactory{
	
	@Override
	public void setUp(boolean hasNeighbours, Position teleportTarget) throws NotMyJobException {
		if (!hasNeighbours || teleportTarget != null) throw new NotMyJobException();
	}
	
    @Override
    public Cell getCell(int givenId, Position givenPosition) {
        return new ClearCell(givenId, givenPosition);
    }

}
