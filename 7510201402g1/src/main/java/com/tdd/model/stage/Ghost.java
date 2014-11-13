package com.tdd.model.stage;

import com.tdd.model.states.StateFactory;
import com.tdd.model.stageAbstractions.State;
import com.tdd.model.stageAbstractions.Direction;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.Position;
import com.tdd.model.stageAbstractions.Protagonist;
import com.tdd.model.stageAbstractions.Stage;
import com.tdd.model.stageAbstractions.StrategyFactory;

public class Ghost extends Enemy {

    private static Integer LAST_ID = 0;
    private State state;
    private StateFactory stateFactory;
    private Integer id;

    public Ghost(Stage stage, Position givenPosition, StateFactory givenFactory,
            StrategyFactory givenStrategyFactory, int givenAwardingPoints, int givenSpeed) {
        super(stage, givenPosition, givenStrategyFactory, givenAwardingPoints, givenSpeed);
        this.stateFactory = givenFactory;
        Ghost.LAST_ID++;
        this.id = Ghost.LAST_ID;
        this.state = this.stateFactory.createHunter(this);
    }

    @Override
    public void kill() {
        this.state = this.stateFactory.createDead(this);
        this.stage.placeEnemyAtHome(this);
    }

    @Override
    public void turnToPrey() {
        this.state = this.stateFactory.createPrey(this);
    }

    @Override
    public void revive() {
        this.state = this.stateFactory.createHunter(this);
    }

    @Override
    public State getState() {
        return this.state;
    }

    @Override
    protected Direction getNextDirection() {
        Direction firstDirection = super.getNextDirection();
        return this.state.getDirection(firstDirection);
    }

    @Override
    public void move() {
        super.move();
        this.advanceGameCycle();
    }

    private void advanceGameCycle() {
        this.state.advanceCycle();
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    // COLLISIONS
    @Override
    public void collideWithProtagonist(Protagonist givenProtagonist) {
        this.state.collideWithProtagonist(givenProtagonist);
    }

}
