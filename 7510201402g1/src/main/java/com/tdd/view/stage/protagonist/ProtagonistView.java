/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tdd.view.stage.protagonist;

import com.tdd.model.stageAbstractions.Protagonist;
import com.tdd.view.Observador;
import java.util.Observable;
import java.util.Observer;

/**
 *
 * 
 */
public class ProtagonistView extends Observador{

    public ProtagonistView(Protagonist protagonist) {
        this.observable = protagonist;
    }


    @Override
    public void update(Observable o, Object arg) {
        System.out.println("actualizacion de " + o + arg);
    }



}
