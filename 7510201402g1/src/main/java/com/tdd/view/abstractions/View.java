package com.tdd.view.abstractions;

import com.tdd.view.helpers.ViewConstants;
import java.awt.Graphics;
import java.util.Observable;
import java.util.Observer;
import javax.swing.ImageIcon;

/**
 *
 *
 * @author agu
 */
public abstract class View implements Observer {

    protected Observable observable;
    protected int x, y, width, heigth;
    protected ImageIcon img;
    protected boolean isShow;

    public View() {
        this.x = 0;
        this.y = 0;
        this.width = ViewConstants.IMAGE_WIDTH_DEFAULT;
        this.heigth = ViewConstants.IMAGE_HEIGHT_DEFAULT;
        this.isShow = true;

    }

    public void setViewPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }
    
    public void paint (Graphics graphics){
        graphics.drawImage(img.getImage(), getXRender(), getYRender(), width, heigth, null);
    }


    private int getXRender() {
        return x * width;
    }

    private int getYRender() {
        return y * heigth + 30;
    }
}
