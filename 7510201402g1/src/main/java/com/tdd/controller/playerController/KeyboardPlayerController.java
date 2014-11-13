package com.tdd.controller.playerController;

import com.tdd.application.gameAbstractions.GameLevel;
import com.tdd.application.gameAbstractions.PacmanGame;
import com.tdd.controller.controllerAbstractions.Controller;
import com.tdd.controller.controllerAbstractions.PlayerController;
import com.tdd.model.directionFactory.DirectionDownFactory;
import com.tdd.model.directionFactory.DirectionFactory;
import com.tdd.model.directionFactory.DirectionLeftFactory;
import com.tdd.model.directionFactory.DirectionRightFactory;
import com.tdd.model.directionFactory.DirectionUpFactory;
import com.tdd.model.exceptions.NoMoreMovementsException;
import com.tdd.model.stageAbstractions.Direction;
import com.tdd.view.manager.ViewManager;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeyboardPlayerController  implements PlayerController, KeyListener {

    private List<Direction> directionsToBeProcessed;
    private Map<Integer, DirectionFactory> directionsDictionary;

    public KeyboardPlayerController() {
        this.directionsToBeProcessed = new ArrayList<Direction>();
        this.directionsDictionary = new HashMap<Integer, DirectionFactory>();
        this.directionsDictionary.put(KeyEvent.VK_RIGHT, new DirectionRightFactory());
        this.directionsDictionary.put(KeyEvent.VK_LEFT, new DirectionLeftFactory());
        this.directionsDictionary.put(KeyEvent.VK_UP, new DirectionUpFactory());
        this.directionsDictionary.put(KeyEvent.VK_DOWN, new DirectionDownFactory());
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("KEY TYPED");        
        // does nothing
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("KEY PRESSED");
        DirectionFactory factory = this.directionsDictionary.get(e.getKeyCode());
        if (factory == null) {
            return;
        }
        this.directionsToBeProcessed.add(factory.createDirection());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("KEY REALEASED");
        // does nothing
    }

    @Override
    public Direction getNewDirection() throws NoMoreMovementsException {
        System.out.println("getNewDirection en KeyboardPlayerController");
        if (!(this.directionsToBeProcessed.isEmpty())) {
            return this.directionsToBeProcessed.remove(0);
        }
        System.out.println("NoMoreMovements");
        throw new NoMoreMovementsException();
        
    }

}
