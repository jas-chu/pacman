/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdd.view.window;

import javax.swing.JFrame;

/**
 *
 *
 */
public class WindowView extends JFrame {

    private String name;

    public WindowView(String name) {
        this.name = name;
        this.initUI();
    }

    public void initUI() {
        setTitle(this.name);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(380, 420);

    }
    
    public JFrame getFrame(){
        return this;
    }
}
