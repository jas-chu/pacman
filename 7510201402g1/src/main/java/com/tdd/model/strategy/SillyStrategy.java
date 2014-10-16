package com.tdd.model.strategy;

import com.tdd.model.ghost.Strategy;
import com.tdd.model.stageAbstractions.Enemy;

public class SillyStrategy extends Strategy {

    public SillyStrategy(Enemy givenEnemy, int vision) {
        super(givenEnemy, vision);
    }

}
