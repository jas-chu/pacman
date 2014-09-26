package com.tdd.model.ghost;

import com.tdd.model.states.Dead;
import com.tdd.model.states.Prey;
import com.tdd.model.states.Hunter;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.Position;

public class Ghost extends Enemy {
    private State state;
    
    public Ghost(Position givenPosition){
		super(givenPosition);
        this.state = new Hunter(this);
    }

    @Override
    public void kill() {
            this.state = new Dead(this);
    }

    @Override
    public void turnToPrey() {
            this.state = new Prey(this);
    }

    @Override
    public void revive() {
            this.state = new Hunter(this);
    }
    
    public State getState(){
        return this.state;
    }	

	@Override
	public void move() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
}
