package com.tdd.view.stage.items;

import com.tdd.model.stageAbstractions.StaticItem;
import com.tdd.view.windowElements.GameContainer;


/**
 *
 *
 */
public class DotView extends ItemView {

    public DotView(StaticItem dot,GameContainer container) {
        super(container);
        this.setViewPosition(dot.getPosition().getX(), dot.getPosition().getY());
        this.observable = dot;
        this.img = this.factory.getDotImage();
    }

}
