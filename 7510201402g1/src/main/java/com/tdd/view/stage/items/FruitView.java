package com.tdd.view.stage.items;

import com.tdd.model.stage.Fruit;
import com.tdd.model.stageAbstractions.MovingItem;
import com.tdd.view.windowElements.GameContainer;
import java.util.Observable;

/**
 *
 *
 */
public class FruitView extends ItemView {

    public FruitView(MovingItem movingItem, GameContainer container) {
        super(container);
        this.setViewPosition(movingItem.getPosition().getX(), movingItem.getPosition().getY());
        this.observable = movingItem;
        this.img = this.factory.getFruitImage();
    }

    @Override
    public void update(Observable observable, Object obj) {        
        Fruit fruit = (Fruit) observable;
        if (fruit.isConsumed()) {
            this.setVisible(false);
            //this.audio.playSound();
        } else {
            this.setVisible(true);
			super.update(observable, obj);
        }
    }



}
