package com.tdd.model.stageAbstractions;

import com.tdd.model.direction.DirectionRight;

public abstract class MovingElement extends StageElement {
	
	protected Direction sense;
	protected Integer speed;
	
    public MovingElement(Stage givenStage, Position givenPosition) {
        super(givenStage, givenPosition);
		this.speed = 1;
		this.sense = new DirectionRight();
    }
	
	public void move() {
        this.removeTeleportedState();
    }
	
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
