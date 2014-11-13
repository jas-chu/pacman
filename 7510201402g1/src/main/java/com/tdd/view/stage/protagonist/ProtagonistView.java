/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdd.view.stage.protagonist;

import com.tdd.model.stageAbstractions.Protagonist;
import com.tdd.view.View;
import com.tdd.view.ViewConstants;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;

/**
 *
 *
 */
public class ProtagonistView extends View {

    public ProtagonistView(Protagonist protagonist) {
        super();
        this.x = protagonist.getPosition().getX();
        this.y = protagonist.getPosition().getY();
        this.observable = protagonist;
    }

    @Override
    public void update(Observable o, Object arg) {
        Protagonist protagonist = (Protagonist) observable;
        this.x = protagonist.getPosition().getX();
        this.y = protagonist.getPosition().getY();
    }
    
        @Override
    public void paintComponents(Graphics graphics) {

        super.paintComponents(graphics);
        ImageIcon img = new ImageIcon(ViewConstants.PACMAN);
        graphics.drawImage(img.getImage(), x, y, width, heigth, null);
    }

}
