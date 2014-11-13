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
        super(0,0,32,32);
        this.observable = enemy;
         //TODO-> levantar esto de configuracion
        
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
        ImageIcon img = new ImageIcon(ViewConstants.ghostViewPath);
    
        graphics.drawImage(img.getImage(), x, y,width,heigth, null);
    }
}
