package com.tdd.view.stage.items;

import com.tdd.model.stageAbstractions.MovingItem;
import com.tdd.view.abstractions.View;
import com.tdd.view.helpers.ViewConstants;
import java.awt.Graphics;
import java.util.Observable;
import javax.swing.ImageIcon;

/**
 *
 *
 */
public class FruitView extends View {

    public FruitView(MovingItem movingItem) {
        super();
        this.x = movingItem.getPosition().getX();
        this.y = movingItem.getPosition().getY();
        this.observable = movingItem;
    }

    @Override
    public void update(Observable observable, Object obj) {
        MovingItem movingItem = (MovingItem) observable;
        this.x = movingItem.getPosition().getX();
        this.y = movingItem.getPosition().getY();

    }

    @Override
    public void paintComponents(Graphics graphics) {

        super.paintComponents(graphics);
        ImageIcon img = new ImageIcon(ViewConstants.FRUIT);
        graphics.drawImage(img.getImage(), x, y, width, heigth, null);
    }

}
