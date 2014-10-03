package com.tdd.model.cell.cellFactory;

import com.tdd.model.cell.TeleportCell;
import com.tdd.model.stageAbstractions.Cell;

/**
 *
 *
 */
public class TeleportCellFactory implements CellFactory {

    @Override
    public Cell getCell() {
        return new TeleportCell();
    }

}
