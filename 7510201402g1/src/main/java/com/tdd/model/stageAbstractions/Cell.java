package com.tdd.model.stageAbstractions;

import java.util.Map;

public abstract class Cell {

    private int id;
    private int row;
    private int column;
    private StageElement element;
    private Map<String, Integer> vecinos;

    public int getId() {
        return this.id;
    }

    public int getRow() {
        return this.row;
    }

    public int getColumn() {
        return this.column;
    }

    public StageElement getElement() {
        return this.element;
    }

    public Map<String, Integer> getVecinos() {
        return this.vecinos;
    }

    public int getVecino(String vecino) {
        return this.vecinos.get(vecino);
    }
}
