package com.tdd.model.ghost;

import com.tdd.model.stageAbstractions.Direction;
import com.tdd.model.stageAbstractions.Enemy;

public abstract class Strategy {
	
	protected Enemy enemy;
	
	public Strategy(Enemy givenEnemy) {
		this.enemy = givenEnemy;
	}
	
	public abstract Direction getDirection();
	
	public abstract void advanceCycle();
	
}
