package com.tdd.view.windowElements;

import com.tdd.view.abstractions.View;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 *
 */
public class GameContainer extends JPanel {

    public List<View> observers;

    public GameContainer() {
        this.observers = new ArrayList<>();
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;
        
        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);
        
        this.observers.stream().forEach((View observer) -> {
            observer.paint(g2d);
        });
    }
}
