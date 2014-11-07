package com.tdd.model.itemBuilding;

import com.tdd.model.stageAbstractions.StaticItem;
import com.tdd.model.stageAbstractions.Position;
import com.tdd.model.stageAbstractions.Stage;

public interface ItemFactory {

    /**
     *
     * @param givenStage
     * @param givenPosition
     * @return
     */
    public StaticItem getItem(Stage givenStage, Position givenPosition);
}
