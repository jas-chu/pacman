package com.tdd.model.mocks;

import com.tdd.model.stageAbstractions.State;
import com.tdd.model.stageAbstractions.Direction;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.Protagonist;

public class MockState extends State {
	
	public boolean getDirectionMethodCalled = false;
	public boolean increaseAngerMethodCalled = false;
	public boolean beEatenMethodCalled = false;
	public boolean advanceCycleMethodCalled = false;
	public boolean turnToPreyMethodCalled = false;
	
	public MockState() {
		super(null);
	}
	
	public MockState(Enemy givenEnemy) {
		super(givenEnemy);
	}
	
	@Override
	public Direction getDirection(Direction givenDirection) {
		this.getDirectionMethodCalled = true;
        return super.getDirection(givenDirection);
    }

	@Override
	public void increaseAnger() {
		this.increaseAngerMethodCalled = true;
	}
	
	@Override
	public void beEaten(com.tdd.model.stageAbstractions.Protagonist givenProtagonist) {
		this.beEatenMethodCalled = true;
	}
	
	@Override
	public void advanceCycle() {
		this.advanceCycleMethodCalled = true;
	}
	
	@Override
	public void collideWithProtagonist(Protagonist givenProtagonist) {
		this.beEaten(givenProtagonist);
	}

	@Override
	protected boolean shouldChangeState() {
		// no need for this
		return false;
	}

	@Override
	protected void changeState() {
		// no need for this
	}
	
	@Override
	public void turnToPrey() {
		this.turnToPreyMethodCalled = true;
		if (this.enemy != null) {
			super.turnToPrey();
		}
	}
	
}
