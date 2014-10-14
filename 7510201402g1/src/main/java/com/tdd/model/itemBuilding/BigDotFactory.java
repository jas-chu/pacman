package com.tdd.model.itemBuilding;

import com.tdd.model.stage.BigDot;
import com.tdd.model.stageAbstractions.Item;
import com.tdd.model.stageAbstractions.Position;
import com.tdd.model.stageAbstractions.Stage;

/**
 *
 * 
 */
public class BigDotFactory implements ItemFactory{

    @Override
    public Item getItem(Stage givenStage, Position givenPosition) {
        return new BigDot(givenStage, givenPosition);
    }

}
