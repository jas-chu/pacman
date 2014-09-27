package com.tdd.model.states;

import com.tdd.model.configuration.Configuration;
import com.tdd.model.stageAbstractions.Direction;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.StageCharacter;

public class Prey extends Passive {

    public Prey(Enemy enemy, int preyCycles) {
        super(enemy, preyCycles);
    }

    @Override
    public void beEaten(StageCharacter p) {
        this.enemy.kill();
    }

	@Override
	public Direction getDirection(Direction givenDirection) {
		return givenDirection.invert();
	}

}
