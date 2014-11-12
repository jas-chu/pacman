package com.tdd.view.stage.enemy;

import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.view.Observador;
import com.tdd.view.ViewConstants;
import java.awt.Graphics;
import java.util.Observable;
import javax.swing.ImageIcon;

/**
 *
 *
 * @author agu
 */
public class GhostView extends Observador {

    public GhostView(Enemy enemy) {
        this.observable = enemy;
    }

    @Override
    public void update(Observable o, Object obj) {
        System.out.println("actualizacion de " + o + obj);
    }

    @Override
    public void paintComponent(Graphics graphics) {
        ImageIcon img = new ImageIcon(getClass().getResource(ViewConstants.ghostViewPath));

        graphics.drawImage(img.getImage(), 0, 0, 32, 32, null);

        setOpaque(false);
        super.paintComponent(graphics);

    }
}
