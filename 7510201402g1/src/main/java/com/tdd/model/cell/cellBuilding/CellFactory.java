package com.tdd.model.cell.cellBuilding;

import com.tdd.model.stageAbstractions.Cell;
import com.tdd.model.stageAbstractions.Position;

/**
 *
 * 
 */
public interface CellFactory {

    public Cell getCell(int givenId, Position givenPosition);
}
