package com.tdd.model.stageAbstractions;

import com.tdd.model.exceptions.BlockedCellException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public abstract class Cell {

    private Integer id;
    private Position position;
    private List<StageElement> elements;
    private Map<String, String> neighboursIds;

    /**
     *
     * @param givenId
     * @param givenPosition
     */
    public Cell(int givenId, Position givenPosition, Map<String, String> givenNeighboursIds) {
        this.id = givenId;
        this.position = new Position(givenPosition);
        this.elements = new ArrayList<StageElement>();
        this.neighboursIds = givenNeighboursIds;
    }

    /**
     *
     * @return
     */
    public Integer getId() {
        return this.id;
    }

    /**
     *
     * @return
     */
    public Integer getRow() {
        return this.position.getY();
    }

    /**
     *
     * @return
     */
    public Integer getColumn() {
        return this.position.getX();
    }

    /**
     *
     * @return
     */
    public Position getPosition() {
        return this.position;
    }

    /**
     *
     * @throws BlockedCellException
     */
    public void testPlaceElement() throws BlockedCellException {
    }

    /**
     *
     * @param givenElement
     */
    public void placeElement(StageElement givenElement) {
        givenElement.setPosition(this.position);
        for (StageElement element : this.elements) {
            givenElement.collideWithElement(element);
        }
        this.elements.add(givenElement);
    }

    /**
     *
     * @param element
     */
    public void removeElement(StageElement element) {
        this.elements.remove(element);
    }

    /**
     *
     * @return
     */
    public List<StageElement> getElements() {
        return this.elements;
    }

    /**
     *
     * @param neighbour
     * @return
     */
    public String getNeighbour(String neighbour) {
        return this.neighboursIds.get(neighbour);
    }
    
    /**
     * 
     * @return 
     */
    public boolean isEmpty(){
        return this.elements.isEmpty();
    }
    /**
     * 
     * @return 
     */
    public String getContent() {
        throw new UnsupportedOperationException("Not supported yet.");
    }
}
