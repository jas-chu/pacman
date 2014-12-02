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

    public void move() {
        for (Integer i = 0; i < this.getSpeed(); ++i) {
            this.moveOneTime();
        }
        this.changeAndNotify();
    }

    protected abstract void moveOneTime();

    public void setSense(Direction sense) {
        this.sense = sense;
    }

    public Direction getSense() {
        return this.sense;
    }

    public void setSpeed(Integer givenSpeed) {
        this.speed = givenSpeed;
    }

    public Integer getSpeed() {
        return this.speed;
    }

    @Override
    public String getMapSerialization() {
        return "";
    }

}
