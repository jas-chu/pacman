package com.tdd.view.stage.items;

import com.tdd.model.stageAbstractions.MovingItem;
import com.tdd.view.abstractions.View;
import com.tdd.view.helpers.ViewConstants;
import java.util.Observable;

/**
 *
 *
 */
public class FruitView extends View {

    public FruitView(MovingItem movingItem) {
        super();
        this.setViewPosition(movingItem.getPosition().getX(), movingItem.getPosition().getY());
        this.observable = movingItem;
        this.imgPath = ViewConstants.FRUIT;
    }

    @Override
    public void update(Observable observable, Object obj) {
        MovingItem movingItem = (MovingItem) observable;
        this.setViewPosition(movingItem.getPosition().getX(), movingItem.getPosition().getY());

    }

   

}
