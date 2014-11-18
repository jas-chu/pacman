package com.tdd.view.stage.items;

import com.tdd.model.stageAbstractions.StaticItem;
import com.tdd.view.windowElements.GameContainer;
import java.util.Observable;

/**
 *
 * 
 */
public class BigDotView extends ItemView{

    public BigDotView(StaticItem bigDot,GameContainer container) {
        super(container);
        this.setViewPosition(bigDot.getPosition().getX(), bigDot.getPosition().getY());
        this.observable = bigDot;
        this.img = this.factory.getBigDotImage();
    }
    
    @Override
    public void update(Observable o, Object arg) {

    }
    


}
