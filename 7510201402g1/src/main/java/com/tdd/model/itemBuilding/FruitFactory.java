
package com.tdd.model.itemBuilding;

import com.tdd.application.configuration.LevelConfigurationsReader;
import com.tdd.model.stage.Fruit;
import com.tdd.model.stageAbstractions.MovingItem;
import com.tdd.model.stageAbstractions.Position;
import com.tdd.model.stageAbstractions.Stage;

/**
 *
 * 
 */
public class FruitFactory implements ItemFactory {

    @Override
    public MovingItem createItem(Stage givenStage, Position givenPosition, LevelConfigurationsReader givenConfigs) {
        int fruitPoints = givenConfigs.getFruitPoints();
		int fruitSpeed = givenConfigs.getItemsSpeed();
		long fruitHiddenCycles = givenConfigs.getFruitHiddenCycles();
		return new Fruit(givenStage, givenPosition, fruitPoints, fruitSpeed, fruitHiddenCycles);
    }

}
