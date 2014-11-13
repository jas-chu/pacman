/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdd.view;

import java.util.Observable;
import java.util.Observer;
import javax.swing.JPanel;

/**
 *
 *
 * @author agu
 */
public abstract class Observador extends JPanel implements Observer {

    protected Observable observable;
    protected int x, y, width, heigth;

    public Observador() {

    }

    public Observador(int x, int y, int width, int heigth) {
        this.x = x;
        this.y = y;
        this.width = width;
        this.heigth = heigth;

    }

    public void update() {
        this.update(observable, this);
    }

}
