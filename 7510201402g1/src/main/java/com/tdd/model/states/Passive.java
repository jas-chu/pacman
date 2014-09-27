package com.tdd.model.states;

import com.tdd.model.ghost.State;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.StageCharacter;

public abstract class Passive extends State {

    private int waitingCycles;

    public Passive(Enemy givenEnemy, int givenWaitingCycles) {
        super(givenEnemy);
        this.waitingCycles = givenWaitingCycles;
    }

    @Override
    public void increaseAnger() {
		// por el momento no hace nada
        // permite agregar funcionalidad
    }

    @Override
    public abstract void beEaten(StageCharacter p);
	
	@Override
	protected boolean shouldChangeState(){
		return (this.countedCycles == this.waitingCycles);
	}

	@Override
	protected void changeState() {
		this.enemy.revive();
	}
	
}
