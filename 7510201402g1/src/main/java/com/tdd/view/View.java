/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdd.view;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 *
 */
public abstract class View extends JPanel {

    private static class RectDraw extends JPanel {

        @Override
        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            g.drawRect(230, 80, 10, 10);
            g.setColor(Color.RED);
            g.fillRect(230, 80, 10, 10);
        }
    }

    public View() {
        RectDraw newrect = new RectDraw();
        this.add(newrect);
    }

    @Override
    public void paintComponent(Graphics g) {
        super.paintComponent(g);
        g.drawRect(230, 80, 10, 10);
        g.setColor(Color.RED);
        g.fillRect(230, 80, 10, 10);
    }
}
