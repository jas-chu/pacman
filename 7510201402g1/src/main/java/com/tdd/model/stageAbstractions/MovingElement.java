package com.tdd.model.stageAbstractions;

import com.tdd.model.helpers.XMLConstants;

public abstract class MovingElement extends StageElement {

    protected Direction sense;
    protected Integer speed;

    public MovingElement(Stage givenStage, Position givenPosition, int givenSpeed) {
        super(givenStage, givenPosition);
        this.speed = givenSpeed;
        this.sense = new Direction(XMLConstants.DIRECTION_RIGHT);
    }

    public synchronized void move() {
        for (Integer i = 0; i < this.getSpeed(); ++i) {
            this.moveOneTime();
        }
        this.changeAndNotify();
    }

    protected abstract void moveOneTime();

    public synchronized void setSense(Direction sense) {
        this.sense = sense;
    }

    public synchronized Direction getSense() {
        return this.sense;
    }

    public synchronized void setSpeed(Integer givenSpeed) {
        this.speed = givenSpeed;
    }

    public synchronized Integer getSpeed() {
        return this.speed;
    }

    @Override
    public String getMapSerialization() {
        return "";
    }

}
