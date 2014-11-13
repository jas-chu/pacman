/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdd.view.abstractions;

import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

/**
 *
 *
 * @author agu
 */
public abstract class View extends JPanel implements Observer {

    protected Observable observable;
    protected int x, y, width, heigth;
    private static final int offset = 32;
    protected String imgPath;

    public View() {
        //TODO-> levantar esto de configuracion
        this.x = 0;
        this.y = 0;
        this.width = 64;
        this.heigth = 64;

    }

    public void setPosition(int x, int y) {
        this.x = x + offset;
        this.y = y;
    }

    @Override
    public void paintComponents(Graphics graphics) {

        super.paintComponents(graphics);
        ImageIcon img = new ImageIcon(this.imgPath);
        graphics.drawImage(img.getImage(), getXRender(), getYRender(), width, heigth, null);
    }

    private int getXRender() {
        return x * width;
    }

    private int getYRender() {
        return y * heigth;
    }
}
