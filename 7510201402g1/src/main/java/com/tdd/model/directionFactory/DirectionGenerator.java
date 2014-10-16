package com.tdd.model.directionFactory;

import com.tdd.model.exceptions.NoAvailableFactoryException;
import com.tdd.model.helpers.XMLConstants;
import com.tdd.model.stageAbstractions.Direction;
import java.util.HashMap;
import java.util.Map;

public class DirectionGenerator {
	
	public static final String DIRECTION_UP_KEY = XMLConstants.DIRECTION_UP;
	public static final String DIRECTION_DOWN_KEY = XMLConstants.DIRECTION_DOWN;
	public static final String DIRECTION_LEFT_KEY = XMLConstants.DIRECTION_LEFT;
	public static final String DIRECTION_RIGHT_KEY = XMLConstants.DIRECTION_RIGHT;
	private Map<String,DirectionFactory> directionFactories;
	
	public DirectionGenerator() {
		this.directionFactories = new HashMap<String,DirectionFactory>();
		this.directionFactories.put(DIRECTION_UP_KEY, new DirectionUpFactory());
		this.directionFactories.put(DIRECTION_DOWN_KEY, new DirectionDownFactory());
		this.directionFactories.put(DIRECTION_LEFT_KEY, new DirectionLeftFactory());
		this.directionFactories.put(DIRECTION_RIGHT_KEY, new DirectionRightFactory());
	}
	
	public Direction createDirection(String directionType) throws NoAvailableFactoryException {
		if (this.directionFactories.containsKey(directionType))
			return this.directionFactories.get(directionType).createDirection();
		throw new NoAvailableFactoryException();
	}
	
}
