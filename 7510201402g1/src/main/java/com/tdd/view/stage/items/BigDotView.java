/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tdd.view.stage.items;

import com.tdd.model.stage.BigDot;
import com.tdd.view.Observador;
import java.util.Observable;

/**
 *
 * 
 */
public class BigDotView extends Observador{

    public BigDotView(BigDot bigDot) {
        this.observable = bigDot;
    }
    
    @Override
    public void update(Observable o, Object arg) {
        System.out.println("actualizacion de "+o+arg);
    }

}