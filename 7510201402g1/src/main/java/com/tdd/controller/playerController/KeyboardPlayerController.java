package com.tdd.controller.playerController;

import com.tdd.controller.controllerAbstractions.PlayerController;
import com.tdd.model.directionFactory.DirectionDownFactory;
import com.tdd.model.directionFactory.DirectionFactory;
import com.tdd.model.directionFactory.DirectionLeftFactory;
import com.tdd.model.directionFactory.DirectionRightFactory;
import com.tdd.model.directionFactory.DirectionUpFactory;
import com.tdd.model.exceptions.NoMoreMovementsException;
import com.tdd.model.stageAbstractions.Direction;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeyboardPlayerController implements PlayerController, KeyListener {

    private final List<Direction> directionsToBeProcessed;
    private final Map<Integer, DirectionFactory> directionsDictionary;
    private Direction lastDirection = null;

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
        // does nothing
    }

    @Override
    public synchronized void keyPressed(KeyEvent e) {
        DirectionFactory factory = this.directionsDictionary.get(e.getKeyCode());
        if (factory == null) {
            return;
        }
        Direction direction = factory.createDirection();
		if (this.lastDirection == null || 
				   !direction.toString().equals(this.lastDirection.toString())) {
			this.directionsToBeProcessed.add(direction);
		}
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // does nothing
    }

    @Override
    public synchronized Direction getNewDirection() throws NoMoreMovementsException {
        if (!(this.directionsToBeProcessed.isEmpty())) {
			this.lastDirection = this.directionsToBeProcessed.remove(0);
			return this.lastDirection;
		}else{
			if (this.lastDirection != null){
				return this.lastDirection;
			}
		}
        throw new NoMoreMovementsException();
    }

}
