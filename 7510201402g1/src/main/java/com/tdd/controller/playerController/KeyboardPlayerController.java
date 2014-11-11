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
	
	private List<Direction> directionsToBeProcessed;
	private Map<Integer,DirectionFactory> directionsDictionary;
	
	public KeyboardPlayerController() {
		this.directionsToBeProcessed = new ArrayList<Direction>();
		this.directionsDictionary = new HashMap<Integer,DirectionFactory>();
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
	public void keyPressed(KeyEvent e) {
		DirectionFactory factory = this.directionsDictionary.get(e.getKeyCode());
		if (factory == null) return;
		this.directionsToBeProcessed.add(factory.createDirection());
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// does nothing
	}
	
	@Override
	public Direction getNewDirection() throws NoMoreMovementsException {
		if (!(this.directionsToBeProcessed.isEmpty())) {
			return this.directionsToBeProcessed.remove(0);
		}
		throw new NoMoreMovementsException();
	}

}
