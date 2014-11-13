package com.tdd.controller.playerController;

import com.sun.corba.se.impl.orbutil.concurrent.Mutex;
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
	private Mutex mutex;

    public KeyboardPlayerController() {
        this.directionsToBeProcessed = new ArrayList<Direction>();
        this.directionsDictionary = new HashMap<Integer, DirectionFactory>();
        this.directionsDictionary.put(KeyEvent.VK_RIGHT, new DirectionRightFactory());
        this.directionsDictionary.put(KeyEvent.VK_LEFT, new DirectionLeftFactory());
        this.directionsDictionary.put(KeyEvent.VK_UP, new DirectionUpFactory());
        this.directionsDictionary.put(KeyEvent.VK_DOWN, new DirectionDownFactory());
		this.mutex = new Mutex();
    }

    @Override
    public void keyTyped(KeyEvent e) {
        System.out.println("KEY TYPED");        
        // does nothing
    }

    @Override
    public void keyPressed(KeyEvent e) {
        System.out.println("keyPressed="+KeyEvent.getKeyText(e.getKeyCode()));
        System.out.println("KEY PRESSED");
        DirectionFactory factory = this.directionsDictionary.get(e.getKeyCode());
        if (factory == null) {
            return;
        }
		
		try {
			mutex.acquire();
			try {
				this.directionsToBeProcessed.add(factory.createDirection());
			} finally {
				mutex.release();
			}
		} catch (InterruptedException ie) {
		}
    }

    @Override
    public void keyReleased(KeyEvent e) {
        System.out.println("KEY REALEASED");
        // does nothing
    }

    @Override
    public Direction getNewDirection() throws NoMoreMovementsException {
		try {
			mutex.acquire();
			try {
				if (!(this.directionsToBeProcessed.isEmpty())) {
					return this.directionsToBeProcessed.remove(0);
				}
			} finally {
				mutex.release();
			}
		} catch (InterruptedException ie) {
		}
		throw new NoMoreMovementsException();
    }

}
