package com.tdd.model.cell;

import com.tdd.model.stageAbstractions.Cell;
import com.tdd.model.stageAbstractions.Position;
import java.util.Map;

public class ClearCell extends Cell {

    public ClearCell(int givenId, Position givenPosition, Map<String, String> givenNeighboursIds) {
        super(givenId, givenPosition, givenNeighboursIds);
    }
   
}
