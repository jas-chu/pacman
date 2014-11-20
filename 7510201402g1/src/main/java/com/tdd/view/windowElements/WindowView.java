package com.tdd.view.windowElements;

import com.tdd.view.helpers.ViewConstants;
import java.awt.Dimension;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import javax.swing.JFrame;

/**
 *
 *
 */
public class WindowView extends JFrame implements WindowListener {

    private String name;
    private static final int PREF_W = 600;
    private static final int PREF_H = 300;

    public WindowView(String name) {
        super(name);
        this.name = name;
        this.setPreferredSize(new Dimension(PREF_W, PREF_H));
        this.setResizable(true);
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

    public void changeSize(int width, int height) {
         this.setPreferredSize(new Dimension(width,height+ViewConstants.LABEL_WIDTH));
         this.pack();
    }

}
