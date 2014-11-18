package com.tdd.model.stage;

import com.tdd.model.helpers.XMLConstants;
import com.tdd.model.stageAbstractions.StaticItem;
import com.tdd.model.stageAbstractions.Position;
import com.tdd.model.stageAbstractions.Stage;

public class BigDot extends StaticItem {

    public BigDot(Stage givenStage, Position givenPosition, int givenAwardingPoints) {
        super(givenStage, givenPosition, givenAwardingPoints);
    }

    @Override
    public int consume() {
        int points = super.consume();
        this.stage.turnEnemiesToPrey();
        this.setChanged();
        return points;
    }

    @Override
    public String getMapSerialization() {
        return XMLConstants.BIG_DOT;
    }

}
