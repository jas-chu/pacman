package com.tdd.model.cell.cellBuilding;

import com.tdd.model.exceptions.NotMyJobException;
import com.tdd.model.stageAbstractions.Cell;
import com.tdd.model.stageAbstractions.Position;
import java.util.Map;

/**
 *
 * 
 */
public interface CellFactory {
	
	public void setUp(boolean hasNeighbours, Position teleportTarget) throws NotMyJobException;
    public Cell getCell(int givenId, Position givenPosition, Map<String, String> givenNeighboursIds);
	
}
