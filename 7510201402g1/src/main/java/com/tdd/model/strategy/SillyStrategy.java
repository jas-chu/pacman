package com.tdd.model.strategy;

import com.tdd.model.stageAbstractions.Strategy;
import com.tdd.model.helpers.XMLConstants;
import com.tdd.model.stageAbstractions.Enemy;

public class SillyStrategy extends Strategy {

    public SillyStrategy(Enemy givenEnemy, int vision) {
        super(givenEnemy, vision);
    }

    @Override
    public String toString() {
        return XMLConstants.SILLY_STRATEGY;
    }
}
