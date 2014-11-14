package com.tdd.view.stage.items;

import com.tdd.model.stageAbstractions.MovingItem;
import com.tdd.view.abstractions.View;
import com.tdd.view.helpers.ViewConstants;
import java.util.Observable;

/**
 *
 *
 */
public class FruitView extends ItemView {

    public FruitView(MovingItem movingItem) {
        super();
        this.setViewPosition(movingItem.getPosition().getX(), movingItem.getPosition().getY());
        this.observable = movingItem;
        this.img = this.factory.getFruitImage();
    }

    @Override
    public void update(Observable observable, Object obj) {
        MovingItem movingItem = (MovingItem) observable;
        if(movingItem.isConsumed()){
            this.observable.deleteObserver(this);
            this.isShow = false;
        }
        this.setViewPosition(movingItem.getPosition().getX(), movingItem.getPosition().getY());

    }

   

}
