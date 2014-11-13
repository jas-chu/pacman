/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdd.view.stage.protagonist;

import com.tdd.model.stageAbstractions.Protagonist;
import com.tdd.view.abstractions.View;
import java.util.Observable;

/**
 *
 *
 */
public class ProtagonistView extends View {
    private ProtagonistViewFactory factory;
    public ProtagonistView(Protagonist protagonist) {
        super();
        this.setViewPosition(protagonist.getPosition().getX(), protagonist.getPosition().getY());
        this.observable = protagonist;
        this.factory = ProtagonistViewFactory.getInstance();
        this.img = this.factory.getDefault();
    }

    @Override
    public void update(Observable o, Object arg) {
        Protagonist protagonist = (Protagonist) observable;
        this.img = this.factory.getImage(protagonist.getSense().toString());
       this.setViewPosition(protagonist.getPosition().getX(), protagonist.getPosition().getY());
    }
    
 

}
