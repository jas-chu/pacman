package com.tdd.model.ghost;

import com.tdd.model.exceptions.BlockedCellException;
import com.tdd.model.exceptions.NoExistingCellException;
import com.tdd.model.stageAbstractions.Direction;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.Position;
import com.tdd.model.stageAbstractions.Protagonist;
import com.tdd.model.stageAbstractions.Stage;
import com.tdd.model.strategyFactory.StrategyFactory;

public class Ghost extends Enemy {

    private State state;
    private StateFactory stateFactory;
    private Strategy strategy;
    private StrategyFactory strategyFactory;
    private Direction sense;
    private static Integer id = 0;

    public Ghost(Stage stage, Position givenPosition, StateFactory givenFactory, StrategyFactory givenStrategy) {
        super(stage, givenPosition);
        this.stateFactory = givenFactory;
        this.strategyFactory = givenStrategy;
        this.state = this.stateFactory.createHunter(this);
        this.strategy = this.strategyFactory.getStrategy(this);
        this.id++;

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
    public void move() {
        super.move();
        int i = 4; // four possible directions
        while (i > 0) {
            Direction firstDirection = this.strategy.getDirection();
            i = this.strategy.getNumberOfPossibleDirections();
            Direction finalDirection = this.state.getDirection(firstDirection);
            Position nextPosition = finalDirection.getNewPosition(this.position);
            try {
                this.stage.placeElement(nextPosition, this);
                i = 0;
            } catch (BlockedCellException | NoExistingCellException error) {
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

    @Override
    public void setSense(Direction sense) {
        this.sense = sense;
    }

    @Override
    public Direction getSense() {
        return this.strategy.getDirection();
    }

    @Override
    public Integer getId() {
        return this.id;
    }

    @Override
    public Strategy getStrategy() {
        return this.strategy;
    }
}
