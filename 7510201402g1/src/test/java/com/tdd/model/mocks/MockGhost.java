package com.tdd.model.mocks;

import com.tdd.model.helpers.XMLConstants;
import com.tdd.model.stageAbstractions.State;
import com.tdd.model.stageAbstractions.Strategy;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.Position;
import com.tdd.model.stageAbstractions.Protagonist;

public class MockGhost extends Enemy {

    public boolean turnToPreyMethodCalled = false;
	public boolean setAsPreyMethodCalled = false;
    public boolean killMethodCalled = false;
    public boolean reviveMethodCalled = false;
    public boolean collideWithProtagonistMethodCalled = false;
    public boolean collideWithItemMethodCalled = false;
    private final MockProtagonist protagonist = new MockProtagonist();
    private Strategy strategy;
    private State state;

    public MockGhost() {
        super(null, new Position(0, 0), new MockStrategyFactory(XMLConstants.LAZY_STRATEGY), 50, 1);
		this.stage = new MockStage();
    }

    @Override
    public void turnToPrey() {
        this.turnToPreyMethodCalled = true;
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
        return !(this.turnToPreyMethodCalled
				|| this.setAsPreyMethodCalled
                || this.killMethodCalled
                || this.reviveMethodCalled
                || this.collideWithProtagonistMethodCalled
                || this.collideWithItemMethodCalled);
    }

    @Override
    public MockProtagonist getProtagonist() {
        return this.protagonist;
    }
	
	@Override
    public MockStage getStage() {
        return (MockStage)this.stage;
    }

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void setState(State state) {
        this.state = state;
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
	public void setAsPrey() {
		this.setAsPreyMethodCalled = true;
	}

}
