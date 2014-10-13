package com.tdd.model.itemFactory;

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
