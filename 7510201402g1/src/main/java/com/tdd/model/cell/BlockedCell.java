package com.tdd.model.cell;

import com.tdd.model.exceptions.BlockedCellException;
import com.tdd.model.stageAbstractions.Cell;
import com.tdd.model.stageAbstractions.Position;
import com.tdd.model.stageAbstractions.StageElement;
import java.util.Map;

public class BlockedCell extends Cell {

    public BlockedCell(int givenId, Position givenPosition, Map<String, String> givenNeighboursIds) {
        super(givenId, givenPosition, givenNeighboursIds);
    }

    @Override
    public void testPlaceElement() throws BlockedCellException {
        throw new BlockedCellException();
    }

    @Override
    public void placeElement(StageElement element) {
        // blocked cell, allows functionality extension
    }

    @Override
    public void removeElement(StageElement element) {
        // blocked cell, allows functionality extension
    }

    @Override
    public String getContent() {
        return super.getContent(); //To change body of generated methods, choose Tools | Templates.
    }

}
