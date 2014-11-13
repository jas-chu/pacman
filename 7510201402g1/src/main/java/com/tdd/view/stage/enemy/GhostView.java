package com.tdd.view.stage.enemy;

import com.tdd.model.stage.Ghost;
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
        super();
        this.x = enemy.getPosition().getX();
        this.y = enemy.getPosition().getY();
        this.observable = enemy;
        

    }

    @Override
    public void update(Observable observable, Object obj) {
        Ghost ghost = (Ghost) observable;
        this.x = ghost.getPosition().getX();
        this.y = ghost.getPosition().getY();

    }

    @Override
    public void paintComponents(Graphics graphics) {

        super.paintComponents(graphics);
        ImageIcon img = new ImageIcon(ViewConstants.GHOST);
        graphics.drawImage(img.getImage(), x, y, width, heigth, null);
    }
}
