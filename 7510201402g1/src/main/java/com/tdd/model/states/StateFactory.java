package com.tdd.model.states;

import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.State;
import java.util.List;

public class StateFactory {
	
	private List<Long> angerWaitingCycles;
	private int deadCycles;
	private int preyCycles;
	
	public StateFactory(List<Long> givenAngerCycles, int givenDeadCycles, int givenPreyCycles) {
		this.angerWaitingCycles = givenAngerCycles;
		this.deadCycles = givenDeadCycles;
		this.preyCycles = givenPreyCycles;
	}
	
	public State createHunter(Enemy givenEnemy) {
		return new Hunter(givenEnemy, this.angerWaitingCycles);
	}

	public State createDead(Enemy givenEnemy) {
		return new Dead(givenEnemy, this.deadCycles);
	}

	public State createPrey(Enemy givenEnemy) {
		return new Prey(givenEnemy, this.preyCycles);
	}
	
}
