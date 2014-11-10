package com.tdd.model.itemBuilding;

import com.tdd.application.configuration.LevelConfigurationsReader;
import com.tdd.model.stageAbstractions.Consumable;
import com.tdd.model.stageAbstractions.Position;
import com.tdd.model.stageAbstractions.Stage;

public interface ItemFactory {

    /**
     *
     * @param givenStage
     * @param givenPosition
	 * @param givenConfigs
     * @return
     */
    public Consumable createItem(Stage givenStage, Position givenPosition, LevelConfigurationsReader givenConfigs);
}
