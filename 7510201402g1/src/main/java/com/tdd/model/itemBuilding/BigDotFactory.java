package com.tdd.model.itemBuilding;

import com.tdd.application.configuration.LevelConfigurationsReader;
import com.tdd.model.stage.BigDot;
import com.tdd.model.stageAbstractions.StaticItem;
import com.tdd.model.stageAbstractions.Position;
import com.tdd.model.stageAbstractions.Stage;

/**
 *
 * 
 */
public class BigDotFactory implements ItemFactory{

    @Override
    public StaticItem createItem(Stage givenStage, Position givenPosition, LevelConfigurationsReader givenConfigs) {
        return new BigDot(givenStage, givenPosition, givenConfigs.getBigDotPoints());
    }

}
