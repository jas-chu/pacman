/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdd.view.window;

import java.awt.Dimension;
import java.awt.event.WindowEvent;
import javax.swing.JFrame;

/**
 *
 *
 */
public class WindowView extends JFrame {

    private String name;

    public WindowView(String name) {
        this.name = name;
        setTitle(this.name);
        this.setSize(600, 400);
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        
    }

    public JFrame getFrame() {
        return this;
    }
}
