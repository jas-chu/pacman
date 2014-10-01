package com.tdd.model.ghost;

import com.tdd.model.states.Dead;
import com.tdd.model.states.Hunter;
import com.tdd.model.states.Prey;
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
	
	public Hunter createHunter(Ghost ghost) {
		return new Hunter(ghost, this.angerWaitingCycles);
	}

	public Dead createDead(Ghost ghost) {
		return new Dead(ghost, this.deadCycles);
	}

	public Prey createPrey(Ghost ghost) {
		return new Prey(ghost, this.preyCycles);
	}
	
}