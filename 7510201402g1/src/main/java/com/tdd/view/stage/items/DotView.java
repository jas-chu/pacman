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
        this.x = dot.getPosition().getX();
        this.y = dot.getPosition().getY();
        this.observable = dot;
    }

    @Override
    public void update(Observable o, Object arg) {
        StaticItem movingItem = (StaticItem) observable;
        this.x = movingItem.getPosition().getX();
        this.y = movingItem.getPosition().getY();
    }

    @Override
    public void paintComponents(Graphics graphics) {

        super.paintComponents(graphics);
        ImageIcon img = new ImageIcon(ViewConstants.DOT);
        graphics.drawImage(img.getImage(), x, y, width, heigth, null);
    }
}
