package com.tdd.view.stage.enemy;

import com.tdd.model.stage.Ghost;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.view.abstractions.View;
import com.tdd.view.helpers.ViewConstants;
import java.awt.Graphics;
import java.util.Observable;
import javax.swing.ImageIcon;

/**
 *
 *
 * @author agu
 */
public class GhostView extends View {

    public GhostView(Enemy enemy) {
        super();
        this.setViewPosition(enemy.getPosition().getX(), enemy.getPosition().getY());
        this.observable = enemy;
        this.imgPath = ViewConstants.GHOST;

    }

    @Override
    public void update(Observable observable, Object obj) {
        Ghost ghost = (Ghost) observable;
        //this.img = ghost.getStatus().toString();
        this.setViewPosition(ghost.getPosition().getX(), ghost.getPosition().getY());
    }

}
