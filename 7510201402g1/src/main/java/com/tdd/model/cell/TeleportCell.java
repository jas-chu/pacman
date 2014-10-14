package com.tdd.model.cell;

import com.tdd.model.exceptions.AlreadyTeleportedException;
import com.tdd.model.stageAbstractions.Cell;
import com.tdd.model.stageAbstractions.Position;
import com.tdd.model.stageAbstractions.StageElement;

public class TeleportCell extends Cell {

    private Cell targetCell = null;

    public TeleportCell(int givenId, Position givenPosition) {
        super(givenId, givenPosition);
    }

    public void setTargetCell(Cell givenCell) {
        this.targetCell = givenCell;
    }

    @Override
    public void placeElement(StageElement element) {
        super.placeElement(element);
        try {
            element.teleport(this.targetCell.getPosition());
        } catch (AlreadyTeleportedException ex) {
            // no action to avoid infinite teleportation loop
        }
    }

}
