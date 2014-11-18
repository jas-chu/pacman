package com.tdd.view.stage.enemy;

import com.tdd.model.helpers.XMLConstants;
import com.tdd.model.stage.Ghost;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.view.abstractions.View;
import com.tdd.view.windowElements.GameContainer;
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

    public GhostView(Enemy enemy, GameContainer container) {
        super(container);
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
        System.out.println(ghost.getState().toString());
        if (ghost.getState().toString().equals(XMLConstants.PREY)) {
            this.img = this.ghostViewFactory.getGhostPreyImage();
        } else if (ghost.getState().toString().equals(XMLConstants.DEAD)) {
            this.img = this.ghostViewFactory.getGhostDeathImage();
        } else if (ghost.getState().toString().equals(XMLConstants.HUNTER)){
                    System.out.println("SOY HUNTER");

             this.img= this.images.get(ghost.getStrategy().getDirection().toString());
        }

        this.setViewPosition(ghost.getPosition().getX(), ghost.getPosition().getY());
    }

}
