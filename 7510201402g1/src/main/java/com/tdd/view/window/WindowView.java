/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdd.view.window;

import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;

/**
 *
 *
 */
public class WindowView extends JFrame  implements WindowListener{

    private String name;

    public WindowView(String name) {
        super(name);
        this.name = name;
        this.setPreferredSize(new Dimension(600, 400));
        this.setLocationRelativeTo(null);
        this.setDefaultCloseOperation(EXIT_ON_CLOSE);
        this.addWindowListener(this);
        this.pack();
        
    }

    @Override
    public void windowOpened(WindowEvent e) {
        System.out.print("windowOpened");
    }

    @Override
    public void windowClosing(WindowEvent e) {
        System.out.print("windowClosing");
    }

    @Override
    public void windowClosed(WindowEvent e) {
        System.out.print("windowClosed");
    }

    @Override
    public void windowIconified(WindowEvent e) {
        System.out.print("windowIconified");
    }

    @Override
    public void windowDeiconified(WindowEvent e) {
        System.out.print("windowDeiconified");
    }

    @Override
    public void windowActivated(WindowEvent e) {
         System.out.print("windowActivated");
    }

    @Override
    public void windowDeactivated(WindowEvent e) {
        System.out.print("windowDeactivated");
    }
  

}
