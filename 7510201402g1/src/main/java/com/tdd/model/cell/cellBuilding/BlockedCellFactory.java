package com.tdd.model.cell.cellBuilding;

import com.tdd.model.cell.BlockedCell;
import com.tdd.model.stageAbstractions.Cell;
import com.tdd.model.stageAbstractions.Position;

/**
 *
 *
 */
public class BlockedCellFactory implements CellFactory {

    @Override
    public Cell getCell(int givenId, Position givenPosition) {
        return new BlockedCell(givenId, givenPosition);
    }

}
