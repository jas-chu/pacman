package com.tdd.model.states;

import com.tdd.model.stageAbstractions.State;
import com.tdd.model.stageAbstractions.Enemy;

public abstract class Passive extends State {

    private int waitingCycles;

    public Passive(Enemy givenEnemy, int givenWaitingCycles) {
        super(givenEnemy);
        this.waitingCycles = givenWaitingCycles;
    }

    @Override
    public void increaseAnger() {
        // does nothing, allows functionality extension.
    }

    @Override
    protected boolean shouldChangeState() {
        return (this.countedCycles == this.waitingCycles);
    }
	
	@Override
    protected void changeState() {
        this.enemy.revive();
    }

}
