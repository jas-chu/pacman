/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdd.view.abstractions;

import com.tdd.view.helpers.ViewConstants;
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
    protected ImageIcon img;
    public View() {
        this.x = 0;
        this.y = 0;
        this.width = ViewConstants.IMAGE_WIDTH_DEFAULT;
        this.heigth = ViewConstants.IMAGE_HEIGHT_DEFAULT;

    }

    public void setViewPosition(int x, int y) {
        this.x = x ;
        this.y = y;
    }

    @Override
    public void paintComponents(Graphics graphics) {

        super.paintComponents(graphics);
        graphics.drawImage(img.getImage(), getXRender(), getYRender(), width, heigth, null);
    }

    private int getXRender() {
        return x * width;
    }

    private int getYRender() {
        return y * heigth + 30;
    }
}
