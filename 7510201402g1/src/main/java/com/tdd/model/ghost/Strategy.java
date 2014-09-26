package com.tdd.model.ghost;

import com.tdd.model.stageAbstractions.Direction;

public abstract class Strategy {
	
	public abstract Direction getDirection();
	
	public abstract void nextCycle();
	
}
