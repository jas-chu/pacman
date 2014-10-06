package com.tdd.model.ghost;

import com.tdd.model.stageAbstractions.Direction;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.Protagonist;
import com.tdd.model.stageAbstractions.StageCharacter;

public abstract class State {
	
	protected Enemy enemy;
	protected int countedCycles;
	
	public State(Enemy givenEnemy) {
		this.enemy = givenEnemy;
		this.countedCycles = 0;
	}
	
    public abstract void increaseAnger();
    public abstract void beEaten(StageCharacter p);
	
    public Direction getDirection(Direction givenDirection) {
        return givenDirection;
    }
	
	public void advanceCycle() {
		this.countedCycles++;
		this.testStateChange();
	}
	
	private void testStateChange() {
		if (this.shouldChangeState())
			this.changeState();
	}
	
	protected abstract boolean shouldChangeState();
	protected abstract void changeState();

	public abstract void collideWithProtagonist(Protagonist givenProtagonist);

}
