package com.tdd.model.stage;

import com.tdd.model.stageAbstractions.Direction;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.Position;
import com.tdd.model.stageAbstractions.Protagonist;
import com.tdd.model.stageAbstractions.Stage;
import com.tdd.model.stageAbstractions.State;
import com.tdd.model.stageAbstractions.StrategyFactory;
import com.tdd.model.states.StateFactory;
import com.tdd.model.strategyFactory.RandomStrategyFactory;

public class Ghost extends Enemy {

    private static Integer LAST_ID = 0;
    private State state;
    private StateFactory stateFactory;
    private Integer id;
    private Position spawnPosition;
    private StrategyFactory strategyFactory;
    private RandomStrategyFactory deadStrategyFactory;
    
    public Ghost(Stage stage, Position givenPosition, StateFactory givenFactory,
            StrategyFactory givenStrategyFactory, int givenAwardingPoints, int givenSpeed) {
        super(stage, givenPosition, givenStrategyFactory, givenAwardingPoints, givenSpeed);
        this.stateFactory = givenFactory;
        Ghost.LAST_ID++;
        this.id = Ghost.LAST_ID;
        this.state = this.stateFactory.createHunter(this);
        this.spawnPosition = givenPosition;
        this.strategyFactory = givenStrategyFactory;
        this.deadStrategyFactory = new RandomStrategyFactory();
    }

    @Override
    public synchronized void kill() {
        this.state = this.stateFactory.createDead(this);
        this.stage.placeEnemyAtHome(this);
        this.strategy = this.deadStrategyFactory.getStrategy(this);
    }

    @Override
    public synchronized void turnToPrey() {
        this.state.turnToPrey();
    }
	
	@Override
    public synchronized void setAsPrey() {
        this.state = this.stateFactory.createPrey(this);
    }

    @Override
    public synchronized void revive() {
        this.state = this.stateFactory.createHunter(this);
        this.strategy = this.strategyFactory.getStrategy(this);
    }

    @Override
    public synchronized State getState() {
        return this.state;
    }

    @Override
    protected synchronized Direction getNextDirection() {
        Direction firstDirection = super.getNextDirection();
        return this.state.getDirection(firstDirection);
    }

    @Override
    public synchronized void move() {
        super.move();
        this.advanceGameCycle();
    }

    private synchronized void advanceGameCycle() {
        this.state.advanceCycle();
    }

    @Override
    public synchronized Integer getId() {
        return this.id;
    }

    // COLLISIONS
    @Override
    public synchronized void collideWithProtagonist(Protagonist givenProtagonist) {        
        this.state.collideWithProtagonist(givenProtagonist);
    }
    

}
