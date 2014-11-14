package com.tdd.view.stage.items;

import com.tdd.model.stageAbstractions.StaticItem;
import com.tdd.view.abstractions.View;
import com.tdd.view.helpers.ViewConstants;
import java.util.Observable;

/**
 *
 * 
 */
public class BigDotView extends ItemView{

    public BigDotView(StaticItem bigDot) {
        super();
        this.setViewPosition(bigDot.getPosition().getX(), bigDot.getPosition().getY());
        this.observable = bigDot;
        this.img = this.factory.getBigDotImage();
    }
    
    @Override
    public void update(Observable o, Object arg) {
        StaticItem staticItem = (StaticItem) observable;
        if(staticItem.isConsumed()){
            this.observable.deleteObserver(this);
            this.isShow = false;
        }
    }
    


}
