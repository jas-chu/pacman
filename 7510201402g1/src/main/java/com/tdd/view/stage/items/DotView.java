package com.tdd.view.stage.items;

import com.tdd.model.stageAbstractions.StaticItem;
import com.tdd.view.abstractions.View;
import com.tdd.view.helpers.ViewConstants;
import java.awt.Graphics;
import java.util.Observable;

import javax.swing.ImageIcon;

/**
 *
 *
 */
public class DotView extends View {

    public DotView(StaticItem dot) {
        super();
        this.setViewPosition(dot.getPosition().getX(), dot.getPosition().getY());
        this.observable = dot;
        this.imgPath = ViewConstants.DOT;
    }

    @Override
    public void update(Observable o, Object arg) {
        StaticItem staticItem = (StaticItem) observable;
        this.setViewPosition(staticItem.getPosition().getX(), staticItem.getPosition().getY());
    }

}
