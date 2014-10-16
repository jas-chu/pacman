package com.tdd.model.stageAbstractions;

import com.tdd.model.exceptions.BlockedCellException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

public abstract class Cell {

    private Integer id;
    private Position position;
    private List<StageElement> elements;
    private Map<String, String> neighboursIds;

    public Cell(int givenId, Position givenPosition, Map<String, String> givenNeighboursIds) {
        this.id = givenId;
        this.position = new Position(givenPosition);
        this.elements = new ArrayList<StageElement>();
        this.neighboursIds = givenNeighboursIds;
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

    public void testPlaceElement() throws BlockedCellException {
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

    public String getNeighbour(String neighbour) {
        return this.neighboursIds.get(neighbour);
    }
    
	public boolean isEmpty(){
        return this.elements.isEmpty();
    }
    
	public String getContent() {
        if (this.elements.isEmpty()) return "";
		return this.elements.get(0).getMapSerialization();
    }
}
