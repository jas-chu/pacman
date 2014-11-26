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
		this.stage.turnEnemiesToPrey();
        return super.consume();
    }

    @Override
    public String getMapSerialization() {
        return XMLConstants.BIG_DOT;
    }

}
