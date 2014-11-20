package com.tdd.view.stage.items;

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
        MovingItem movingItem = (MovingItem) observable;
        if (movingItem.isConsumed()) {
            //saco por ahora el sonido de comer a la fruta
            //this.audio.playSound();
            this.container.removeView(this);
            
        } else {
            if (!(this.container.hasView(this))) {
                this.container.addVolatileView(this);
            }
        }
        this.setViewPosition(movingItem.getPosition().getX(), movingItem.getPosition().getY());

    }

}
