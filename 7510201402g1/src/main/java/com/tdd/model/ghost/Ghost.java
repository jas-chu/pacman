package com.tdd.model.ghost;

import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.Position;

public class Ghost extends Enemy {
    private State state;
	private StateFactory factory;
    
    public Ghost(Position givenPosition, StateFactory givenFactory){
		super(givenPosition);
		this.factory = givenFactory;
        this.state = this.factory.createHunter(this);
    }

    @Override
    public void kill() {
        this.state = this.factory.createDead(this);
    }

    @Override
    public void turnToPrey() {
            this.state = this.factory.createPrey(this);
    }

    @Override
    public void revive() {
            this.state = this.factory.createHunter(this);
    }
    
    public State getState(){
        return this.state;
    }	

	@Override
	public void move() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void advanceCycle() {
		this.state.advanceCycle();
	}
}
