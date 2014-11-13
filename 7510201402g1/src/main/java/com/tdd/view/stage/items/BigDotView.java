package com.tdd.view.stage.items;

import com.tdd.model.stageAbstractions.StaticItem;
import com.tdd.view.abstractions.View;
import com.tdd.view.helpers.ViewConstants;
import java.util.Observable;

/**
 *
 * 
 */
public class BigDotView extends View{

    public BigDotView(StaticItem bigDot) {
        super();
        this.setViewPosition(bigDot.getPosition().getX(), bigDot.getPosition().getY());
        this.observable = bigDot;
        this.imgPath = ViewConstants.BIG_DOT;
    }
    
    @Override
    public void update(Observable o, Object arg) {
        StaticItem staticItem = (StaticItem) observable;
        this.setViewPosition(staticItem.getPosition().getX(), staticItem.getPosition().getY());
    }
    


}
