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
    private Map<String, Integer> neighbours;

    /**
     *
     * @param givenId
     * @param givenPosition
     */
    public Cell(int givenId, Position givenPosition) {
        this.id = givenId;
        this.position = new Position(givenPosition);
        this.elements = new ArrayList<StageElement>();
        this.neighbours = new HashMap<String, Integer>();
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
     * @return
     */
    public Map<String, Integer> getNeighbours() {
        return this.neighbours;
    }

    /**
     *
     * @param neighbour
     * @return
     */
    public Integer getNeighbour(String neighbour) {
        return this.neighbours.get(neighbour);
    }

    /**
     *
     * @param neighbour
     * @param neighbourId
     */
    public void setNeighbour(String neighbour, Integer neighbourId) {
        this.neighbours.put(neighbour, neighbourId);
    }

    /**
     *
     * @param neighbours
     */
    public void setNeighbours(Map<String, Integer> neighbours) {
        this.neighbours = neighbours;
    }
    
    /**
     * 
     * @return 
     */
    public boolean isEmpty(){
        return this.elements.isEmpty();
    }

    public String getContent() {
       String content = "";
       if(!this.isEmpty()){
           //Ver como retornar bolita y bolon
       }
       return content;
    }
}
