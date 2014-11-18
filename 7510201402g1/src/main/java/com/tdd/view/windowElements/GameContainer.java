package com.tdd.view.windowElements;

import com.tdd.view.abstractions.View;
import com.tdd.view.messages.DinamycMessage;
import com.tdd.view.messages.Message;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 *
 */
public class GameContainer extends JPanel {

    /**
     * Lista of stable views (Eg. Protagonis,enemy,cell)
     */
    private List<View> stableViews;
    /**
     * Lista of volatile views (Eg. dot,bigDot)
     */
    private List<View> volatileViews;

    private List<Message> labels;

    public GameContainer() {
        this.stableViews = new ArrayList<>();
        this.volatileViews = new ArrayList<>();
        this.labels = new ArrayList<>();
    }

    public void addStableView(View view) {
        this.stableViews.add(view);
    }

    public void removeView(View view) {
        if (this.stableViews.contains(view)) {
            this.stableViews.remove(view);
        } else {
            this.volatileViews.remove(view);
        }
    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2d = (Graphics2D) g;

        g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
                RenderingHints.VALUE_ANTIALIAS_ON);

        this.stableViews.stream().forEach((View observer) -> {
            observer.paint(g2d);
        });

        this.volatileViews.stream().forEach((View observer) -> {
            observer.paint(g2d);
        });
        this.labels.stream().forEach((Message label) -> {
            label.paint(g2d);
        });

    }

    public void clear() {
        this.removeAll();
        this.stableViews.clear();
        this.volatileViews.clear();
    }

    public void addLabel(JLabel label) {
        this.add(label);
    }

    public void addDinamycLabel(DinamycMessage label) {
        this.labels.add(label);
    }

    public void addVolatileView(View view) {
        this.volatileViews.add(view);
    }

    public void resetVolatileViews() {
        this.volatileViews.clear();
    }
}
