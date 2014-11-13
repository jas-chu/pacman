/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdd.view.stage.protagonist;

import com.tdd.model.stageAbstractions.Protagonist;
import com.tdd.view.abstractions.View;
import com.tdd.view.helpers.ViewConstants;
import java.awt.Graphics;
import java.util.Observable;
import javax.swing.ImageIcon;

/**
 *
 *
 */
public class ProtagonistView extends View {

    public ProtagonistView(Protagonist protagonist) {
        super();
        this.setPosition(protagonist.getPosition().getX(), protagonist.getPosition().getY());
        this.observable = protagonist;
        this.imgPath = ViewConstants.PACMAN;
    }

    @Override
    public void update(Observable o, Object arg) {
        Protagonist protagonist = (Protagonist) observable;
        //this.img = protagonist.getDirection().toString();
       this.setPosition(protagonist.getPosition().getX(), protagonist.getPosition().getY());
    }
    
 

}
