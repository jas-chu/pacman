package com.tdd.view.stage.items;

import com.tdd.model.stageAbstractions.StaticItem;
import java.util.Observable;


/**
 *
 *
 */
public class DotView extends ItemView {

    public DotView(StaticItem dot) {
        super();
        this.setViewPosition(dot.getPosition().getX(), dot.getPosition().getY());
        this.observable = dot;
        this.img = this.factory.getDotImage();
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
