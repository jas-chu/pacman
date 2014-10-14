package com.tdd.model.cell.cellBuilding;

import com.tdd.model.cell.BlockedCell;
import com.tdd.model.exceptions.NotMyJobException;
import com.tdd.model.stageAbstractions.Cell;
import com.tdd.model.stageAbstractions.Position;
import java.util.Map;

/**
 *
 *
 */
public class BlockedCellFactory implements CellFactory {
	
	@Override
	public void setUp(boolean hasNeighbours, Position teleportTarget) throws NotMyJobException {
		if (hasNeighbours || teleportTarget != null) throw new NotMyJobException();
	}
	
    @Override
    public Cell getCell(int givenId, Position givenPosition, Map<String, String> givenNeighboursIds) {
        return new BlockedCell(givenId, givenPosition, givenNeighboursIds);
    }
	
}
