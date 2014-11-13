package com.tdd.model.stageAbstractions;

import com.tdd.model.exceptions.BlockedCellException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Observable;

public class Cell extends Observable{

    private Integer id;
    private Position position;
    private List<StageElement> elements;
    private Map<String, Position> neighbours;

    public Cell(int givenId, Position givenPosition, Map<String, Position> givenNeighbours) {
        this.id = givenId;
        this.position = new Position(givenPosition);
        this.elements = new ArrayList<StageElement>();
        if (givenNeighbours != null) {
			this.neighbours = givenNeighbours;
		} else {
			this.neighbours = new HashMap<String, Position>();
		}
    }

    public Integer getId() {
        return this.id;
    }

    public Integer getRow() {
        return this.position.getY();
    }

    public Integer getColumn() {
        return this.position.getX();
    }

    public Position getPosition() {
        return this.position;
    }

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
	
	public boolean hasNeighbour(String neighbourKey) {
		return this.neighbours.containsKey(neighbourKey);
	}
	
    public String getNeighbour(String neighbourKey) {
        if (this.hasNeighbour(neighbourKey)) {
			return this.neighbours.get(neighbourKey).toString();
		}
		else return "";
    }

    public boolean isEmpty() {
        return this.elements.isEmpty();
    }

    public String getContent() {
        if (this.elements.isEmpty()) {
            return "";
        }
        return this.elements.get(0).getMapSerialization();
    }
	
	public Position getTargetPosition(Direction direction) throws BlockedCellException {
		String targetKey = direction.toString();
		if (this.hasNeighbour(targetKey)) {
			return this.neighbours.get(targetKey);
		}
		throw new BlockedCellException();
	}
	
}
