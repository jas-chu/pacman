package com.tdd.model.states;

import com.tdd.model.configuration.Configuration;
import com.tdd.model.stageAbstractions.Direction;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.StageCharacter;
import com.tdd.model.stageAbstractions.Revividor;

public class Prey extends Passive {

    public Prey(Enemy enemigo) {
        super(enemigo, new Revividor(enemigo), Prey.getPreyTime());
    }

    @Override
    public void beEaten(StageCharacter p) {
        this.enemy.kill();
    }

    private static int getPreyTime() {
        return Configuration.getConfiguration().getPreyTime().intValue();
    }

	@Override
	public Direction getDirection(Direction givenDirection) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

}
