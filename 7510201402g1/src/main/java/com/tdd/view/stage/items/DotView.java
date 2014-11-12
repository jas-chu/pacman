/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tdd.view.stage.items;

import com.tdd.model.stageAbstractions.StaticItem;
import com.tdd.view.Observador;
import java.util.Observable;

import java.util.Observer;

/**
 *
 * 
 */
public class DotView extends Observador{

    public DotView(StaticItem staticItem) {
        this.observable = staticItem;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("actualizacion de " + o + arg);
    }

}
