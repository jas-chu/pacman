package com.tdd.model.mocks;

import com.tdd.model.exceptions.BlockedCellException;
import com.tdd.model.stageAbstractions.State;
import com.tdd.model.stageAbstractions.Strategy;
import com.tdd.model.stageAbstractions.Direction;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.StaticItem;
import com.tdd.model.stageAbstractions.Position;
import com.tdd.model.stageAbstractions.Protagonist;

public class MockGhost extends Enemy {

    public boolean turnToPreyMethodCalled = false;
    public boolean advanceCycleMethodCalled = false;
    public boolean killMethodCalled = false;
    public boolean reviveMethodCalled = false;
    public boolean collideWithProtagonistMethodCalled = false;
    public boolean collideWithItemMethodCalled = false;
    private final MockProtagonist protagonist = new MockProtagonist();
    private Strategy strategy;
    private State state;
    private MockStage stage = new MockStage();
    private Direction sense;

    public MockGhost() {
        super(null, new Position(0, 0));
    }

    @Override
    public void turnToPrey() {
        this.turnToPreyMethodCalled = true;
    }

    @Override
    public void advanceCycle() {
        this.advanceCycleMethodCalled = true;
    }

    @Override
    public void kill() {
        this.killMethodCalled = true;
    }

    @Override
    public void revive() {
        this.reviveMethodCalled = true;
    }

    @Override
    public void collideWithProtagonist(Protagonist givenProtagonist) {
        this.collideWithProtagonistMethodCalled = true;
    }

    @Override
    public void collideWithConsumable(com.tdd.model.stageAbstractions.Consumable givenConsumable) {
        this.collideWithItemMethodCalled = true;
    }

    public boolean noMethodWasCalled() {
        return !(this.advanceCycleMethodCalled
                || this.turnToPreyMethodCalled
                || this.killMethodCalled
                || this.reviveMethodCalled
                || this.collideWithProtagonistMethodCalled
                || this.collideWithItemMethodCalled);
    }

    @Override
    public MockProtagonist getProtagonist() {
        return this.protagonist;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setState(State state) {
        this.state = state;
    }

    @Override
    public MockStage getStage() {
        return this.stage;
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
            } catch (BlockedCellException error) {
                i--; // must look another way
            }
        }
        this.advanceCycle();
    }

    @Override
    public void setSense(Direction sense) {
        this.sense = sense;
    }

    @Override
    public Direction getSense() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public State getState() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Integer getId() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public Strategy getStrategy() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
