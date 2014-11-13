package com.tdd.view.stage.enemy;

import com.tdd.model.helpers.XMLConstants;
import com.tdd.model.stage.Ghost;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.view.abstractions.View;
import java.util.HashMap;
import java.util.Observable;
import javax.swing.ImageIcon;

/**
 *
 *
 * @author agu
 */
public class GhostView extends View {

    HashMap<String, ImageIcon> images;
    GhostViewFactory ghostViewFactory;

    public GhostView(Enemy enemy) {
        super();
        this.setViewPosition(enemy.getPosition().getX(), enemy.getPosition().getY());
        this.observable = enemy;
        this.ghostViewFactory = new GhostViewFactory();
        this.images = ghostViewFactory.getGhostImages();
        //Por defecto los fantasmas van a empezar mirando a la derecha
        this.img = this.images.get(XMLConstants.DIRECTION_LEFT);
    }

      @Override
    public void update(Observable observable, Object obj) {
        Ghost ghost = (Ghost) observable;
//        this.img = this.images.get(ghost.getStrategy().getDirection().toString());
        this.setViewPosition(ghost.getPosition().getX(), ghost.getPosition().getY());
    }

}
