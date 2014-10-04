package com.tdd.model.cell.cellBuilding;

import com.tdd.model.cell.TeleportCell;
import com.tdd.model.stageAbstractions.Cell;
import com.tdd.model.stageAbstractions.Position;

/**
 *
 *
 */
public class TeleportCellFactory implements CellFactory {

    @Override
    public Cell getCell(int givenId, Position givenPosition) {
        return new TeleportCell(givenId, givenPosition);
    }

}
