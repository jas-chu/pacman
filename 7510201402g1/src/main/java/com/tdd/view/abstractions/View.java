/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdd.view.abstractions;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

/**
 *
 *
 * @author agu
 */
public abstract class View extends JPanel implements Observer {

    protected Observable observable;
    protected int x, y, width, heigth;

 
    public View() {
        //TODO-> levantar esto de configuracion
        this.x = 0;
        this.y = 0;
        this.width = 32;
        this.heigth = 32;

    }

}
