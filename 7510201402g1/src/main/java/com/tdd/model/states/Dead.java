package com.tdd.model.states;

import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.Protagonist;
import com.tdd.model.stageAbstractions.StageCharacter;

public class Dead extends Passive {

    public Dead(Enemy enemy, int deadCycles) {
        super(enemy, deadCycles);
    }

    @Override
    public void beEaten(StageCharacter p) {
        // for the moment, it doesn't do anything
        // it allows functionality addition
    }

	@Override
	public void collideWithProtagonist(Protagonist givenProtagonist) {
		// does nothing, allows functionality extension.
	}
	
}
