package com.tdd.view;

import java.awt.Graphics;
import java.util.Observable;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 *
 */
public class Sample extends Observador {

    @Override
    public void update(Observable o, Object arg) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void paintComponent(Graphics graphics) {
        ImageIcon img = new ImageIcon(ViewConstants.sampleViewPath);
        JLabel label = new JLabel(img);
        label.setBounds(0, 0, this.getWidth(), this.getHeight());
        this.add(label);
//        graphics.drawImage(img.getImage(), 0, 0, getWidth(), getHeight(), null);
        super.paintComponent(graphics);

    }
}
