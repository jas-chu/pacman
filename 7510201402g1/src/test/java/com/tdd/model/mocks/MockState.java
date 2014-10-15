package com.tdd.model.mocks;

import com.tdd.model.ghost.State;
import com.tdd.model.stageAbstractions.Direction;
import com.tdd.model.stageAbstractions.Protagonist;
import com.tdd.model.stageAbstractions.StageCharacter;

public class MockState extends State {
	
	public boolean getDirectionMethodCalled = false;
	public boolean increaseAngerMethodCalled = false;
	public boolean beEatenMethodCalled = false;
	public boolean advanceCycleMethodCalled = false;
	
	public MockState() {
		super(null);
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
	public void beEaten(StageCharacter p) {
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

}
