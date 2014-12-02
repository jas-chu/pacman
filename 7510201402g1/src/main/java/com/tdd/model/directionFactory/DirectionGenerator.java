package com.tdd.model.directionFactory;

import com.tdd.model.exceptions.NoAvailableFactoryException;
import com.tdd.model.helpers.XMLConstants;
import com.tdd.model.stageAbstractions.Direction;
import java.util.HashMap;
import java.util.Map;

public class DirectionGenerator {
	
	private Map<String,DirectionFactory> directionFactories;
	
	public DirectionGenerator() {
		this.directionFactories = new HashMap<>();
		this.directionFactories.put(XMLConstants.DIRECTION_UP, new DirectionFactory(XMLConstants.DIRECTION_UP));
		this.directionFactories.put(XMLConstants.DIRECTION_DOWN, new DirectionFactory(XMLConstants.DIRECTION_DOWN));
		this.directionFactories.put(XMLConstants.DIRECTION_LEFT, new DirectionFactory(XMLConstants.DIRECTION_LEFT));
		this.directionFactories.put(XMLConstants.DIRECTION_RIGHT, new DirectionFactory(XMLConstants.DIRECTION_RIGHT));
	}
	
	public Direction createDirection(String directionType) throws NoAvailableFactoryException {
		if (this.directionFactories.containsKey(directionType))
			return this.directionFactories.get(directionType).createDirection();
		throw new NoAvailableFactoryException();
	}
	
}
