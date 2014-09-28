package com.tdd.model.ghost;

import com.tdd.model.stage.Labyrinth;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.Position;
import com.tdd.model.stageAbstractions.Stage;

public class Ghost extends Enemy {
    private State state;
	private StateFactory factory;
	private Strategy strategy;
    
    public Ghost(Stage stage, Position givenPosition, StateFactory givenFactory, Strategy givenStrategy){
		super(stage, givenPosition);
		this.factory = givenFactory;
        this.state = this.factory.createHunter(this);
		this.strategy = givenStrategy;
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
		
	}

	@Override
	public void advanceCycle() {
		this.state.advanceCycle();
		this.strategy.advanceCycle();
	}
}
