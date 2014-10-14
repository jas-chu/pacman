package com.tdd.model.cell;

import com.tdd.model.exceptions.AlreadyTeleportedException;
import com.tdd.model.stageAbstractions.Cell;
import com.tdd.model.stageAbstractions.Position;
import com.tdd.model.stageAbstractions.StageElement;
import java.util.Map;

public class TeleportCell extends Cell {

    private Position targetCell;

    public TeleportCell(int givenId, Position givenPosition, Map<String, String> givenNeighboursIds, Position givenTargetCell) {
        super(givenId, givenPosition, givenNeighboursIds);
		this.targetCell = givenTargetCell;
    }

    @Override
    public void placeElement(StageElement element) {
        super.placeElement(element);
        try {
            element.teleport(this.targetCell);
        } catch (AlreadyTeleportedException ex) {
            // no action to avoid infinite teleportation loop
        }
    }

}
