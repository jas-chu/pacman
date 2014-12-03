package com.tdd.controller.playerController;

import com.tdd.controller.controllerAbstractions.PlayerController;
import com.tdd.model.exceptions.NoMoreMovementsException;
import com.tdd.model.helpers.XMLConstants;
import com.tdd.model.stageAbstractions.Direction;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class KeyboardPlayerController implements PlayerController, KeyListener {

    private final List<Direction> directionsToBeProcessed;
    private final Map<Integer, String> directionsDictionary;
    private Direction lastDirection = null;

    public KeyboardPlayerController() {
        this.directionsToBeProcessed = new ArrayList<>();
        this.directionsDictionary = new HashMap<>();
        this.directionsDictionary.put(KeyEvent.VK_RIGHT, XMLConstants.DIRECTION_RIGHT);
        this.directionsDictionary.put(KeyEvent.VK_LEFT, XMLConstants.DIRECTION_LEFT);
        this.directionsDictionary.put(KeyEvent.VK_UP, XMLConstants.DIRECTION_UP);
        this.directionsDictionary.put(KeyEvent.VK_DOWN, XMLConstants.DIRECTION_DOWN);
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // does nothing
    }

    @Override
    public synchronized void keyPressed(KeyEvent e) {
        String directionName = this.directionsDictionary.get(e.getKeyCode());
        if (directionName == null) {
            return;
        }
        Direction direction = new Direction(directionName);
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
