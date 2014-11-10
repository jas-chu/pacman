
package com.tdd.model.itemBuilding;

import com.tdd.application.configuration.LevelConfigurationsReader;
import com.tdd.model.stage.Dot;
import com.tdd.model.stageAbstractions.StaticItem;
import com.tdd.model.stageAbstractions.Position;
import com.tdd.model.stageAbstractions.Stage;

/**
 *
 * 
 */
public class DotFactory implements ItemFactory{

    @Override
    public StaticItem createItem(Stage givenStage, Position givenPosition, LevelConfigurationsReader givenConfigs) {
        return new Dot(givenStage, givenPosition, givenConfigs.getDotPoints());
    }

}
