package com.tdd.model.stageAbstractions;

import com.tdd.model.helpers.XMLConstants;
import java.util.HashMap;
import java.util.Map;

public class Direction {
	
	private interface Inversion {
		Position invert(Position givenPosition);
	}
	
	private static Map<String,Inversion> POSITIONS_MAP = initPositionsMap();
	private static Map<String,String> INVERSIONS_MAP = initInversionsMap();
	
	private static Map<String,Inversion> initPositionsMap() {
		Map<String,Inversion> map = new HashMap<>();
		map.put(XMLConstants.DIRECTION_RIGHT, Position::createRightAdjacentPosition);
		map.put(XMLConstants.DIRECTION_LEFT, Position::createLeftAdjacentPosition);
		map.put(XMLConstants.DIRECTION_UP, Position::createUpAdjacentPosition);
		map.put(XMLConstants.DIRECTION_DOWN, Position::createDownAdjacentPosition);
		return map;
	}
	
	private static Map<String,String> initInversionsMap() {
		Map<String,String> map = new HashMap<>();
		map.put(XMLConstants.DIRECTION_RIGHT, XMLConstants.DIRECTION_LEFT);
		map.put(XMLConstants.DIRECTION_LEFT, XMLConstants.DIRECTION_RIGHT);
		map.put(XMLConstants.DIRECTION_UP, XMLConstants.DIRECTION_DOWN);
		map.put(XMLConstants.DIRECTION_DOWN, XMLConstants.DIRECTION_UP);
		return map;
	}
	
	public static int getNumberOfPossibleDirections() {
		return 4;
	}
	
	private String direction;
	
	public Direction(String givenDirection) {
		this.direction = givenDirection;
	}
	
	public Position getNewPosition(Position position) {
		if (Direction.POSITIONS_MAP.containsKey(this.direction)) {
			Inversion inversion = Direction.POSITIONS_MAP.get(this.direction);
			return inversion.invert(position);
		}
		return position;
	}
	
	public Direction invert() {
		if (Direction.INVERSIONS_MAP.containsKey(this.direction)) {
			String invertedDirection = Direction.INVERSIONS_MAP.get(this.direction);
			return new Direction(invertedDirection);
		}
		return new Direction(this.direction);
	}
	
	@Override
	public String toString() {
		return this.direction;
	}
}
