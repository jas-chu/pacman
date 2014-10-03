package com.tdd.model.cell.cellFactory;

import com.tdd.model.cell.BlockedCell;
import com.tdd.model.stageAbstractions.Cell;

/**
 *
 *
 */
public class BlockedCellFactory implements CellFactory {

    @Override
    public Cell getCell() {
        return new BlockedCell();
    }

}
