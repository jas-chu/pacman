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
public class BigDotView extends View{

    public BigDotView(StaticItem bigDot) {
        super();
        this.x = bigDot.getPosition().getX();
        this.y = bigDot.getPosition().getY();
        this.observable = bigDot;
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
        ImageIcon img = new ImageIcon(ViewConstants.BIG_DOT);
        graphics.drawImage(img.getImage(), x, y, width, heigth, null);
    }

}
