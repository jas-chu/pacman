
package com.tdd.model.itemBuilding;

import com.tdd.model.stage.Dot;
import com.tdd.model.stageAbstractions.Item;
import com.tdd.model.stageAbstractions.Position;
import com.tdd.model.stageAbstractions.Stage;

/**
 *
 * 
 */
public class DotFactory implements ItemFactory{

    @Override
    public Item getItem(Stage givenStage, Position givenPosition) {
        return new Dot(givenStage, givenPosition);
    }

}
