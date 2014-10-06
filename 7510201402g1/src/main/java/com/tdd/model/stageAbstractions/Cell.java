package com.tdd.model.stageAbstractions;

import com.tdd.model.exceptions.BlockedCellException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Cell {

    private int id;
	private Position position;
    private List<StageElement> elements;
    private Map<String, Integer> neighbours;
	
	public Cell(int givenId, Position givenPosition) {
		this.id = givenId;
		this.position = new Position (givenPosition);
		this.elements = new ArrayList<StageElement>();
		this.neighbours = new HashMap<String,Integer>();
	}
	
    public int getId() {
        return this.id;
    }

    public int getRow() {
		return this.position.getY();
    }

    public int getColumn() {
		return this.position.getX();
    }
	
	public Position getPosition() {
		return this.position;
	}
	
	public void testPlaceElement() throws BlockedCellException { }
	
	public void placeElement(StageElement givenElement) {
		givenElement.setPosition(this.position);
		for (StageElement element : this.elements) {
			givenElement.collideWithElement(element);
		}
		this.elements.add(givenElement);
	}
	
	public void removeElement(StageElement element) {
		this.elements.remove(element);
	}
	
    public List<StageElement> getElements() {
        return this.elements;
    }

    public Map<String, Integer> getNeighbours() {
        return this.neighbours;
    }

    public int getNeighbour(String neighbour) {
        return this.neighbours.get(neighbour);
    }
	
}
