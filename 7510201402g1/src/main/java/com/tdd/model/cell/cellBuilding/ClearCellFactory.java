package com.tdd.model.cell.cellBuilding;

import com.tdd.model.cell.ClearCell;
import com.tdd.model.stageAbstractions.Cell;
import com.tdd.model.stageAbstractions.Position;

/**
 *
 * 
 */
public class ClearCellFactory implements CellFactory{

    @Override
    public Cell getCell(int givenId, Position givenPosition) {
        return new ClearCell(givenId, givenPosition);
    }

}
