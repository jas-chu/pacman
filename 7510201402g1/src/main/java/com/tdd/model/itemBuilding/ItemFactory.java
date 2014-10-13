package com.tdd.model.itemBuilding;

import com.tdd.model.stageAbstractions.Item;
import com.tdd.model.stageAbstractions.Position;
import com.tdd.model.stageAbstractions.Stage;

public interface ItemFactory {

    /**
     *
     * @param givenStage
     * @param givenPosition
     * @return
     */
    public Item getItem(Stage givenStage, Position givenPosition);
}
