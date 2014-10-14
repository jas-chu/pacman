package com.tdd.model.cell.cellBuilding;

import com.tdd.model.cell.TeleportCell;
import com.tdd.model.exceptions.NotMyJobException;
import com.tdd.model.stageAbstractions.Cell;
import com.tdd.model.stageAbstractions.Position;

/**
 *
 *
 */
public class TeleportCellFactory implements CellFactory {
	
	Position targetCell;
	
	@Override
	public void setUp(boolean hasNeighbours, Position teleportTarget) throws NotMyJobException {
		if (!hasNeighbours || teleportTarget == null) throw new NotMyJobException();
		this.targetCell = teleportTarget;
	}
	
    @Override
    public Cell getCell(int givenId, Position givenPosition) {
        return new TeleportCell(givenId, givenPosition, this.targetCell);
    }
}
