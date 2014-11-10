/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdd.view.app;

import javax.swing.JFrame;

/**
 *
 *
 */
public class AppView extends JFrame {

    private String name;

    public AppView(String name) {
        this.name = name;
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
