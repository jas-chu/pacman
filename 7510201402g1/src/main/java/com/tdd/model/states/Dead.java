package com.tdd.model.states;

import com.tdd.model.helpers.XMLConstants;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.Protagonist;

public class Dead extends Passive {

    public Dead(Enemy enemy, int deadCycles) {
        super(enemy, deadCycles);
    }

    @Override
    public void beEaten(Protagonist givenProtagonist) {
        // does nothing, allows functionality extension.
    }

    @Override
    public String toString() {
        return XMLConstants.DEAD;
    }
}
