package com.tdd.model.ghost;

import com.tdd.model.exceptions.BlockedCellException;
import com.tdd.model.stageAbstractions.Direction;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.Position;
import com.tdd.model.stageAbstractions.Protagonist;
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
		this.stage.placeEnemyAtHome(this);
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
		super.move();
		int i = 4; // four possible directions
		while (i > 0) {
			Direction firstDirection = this.strategy.getDirection();
			Direction finalDirection = this.state.getDirection(firstDirection);
			Position nextPosition = finalDirection.getNewPosition(this.position);
			try {
				this.stage.placeElement(nextPosition, this);
			} catch (BlockedCellException error) {
				i--; // must look another way
			}
		}
		this.advanceCycle();
	}

	@Override
	public void advanceCycle() {
		this.state.advanceCycle();
		this.strategy.advanceCycle();
	}
	
	// COLLISIONS
	
	@Override
	public void collideWithProtagonist(Protagonist givenProtagonist) {
		this.state.collideWithProtagonist(givenProtagonist);
	}
}
