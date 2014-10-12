package com.tdd.model.strategy;

import com.tdd.model.ghost.Strategy;
import com.tdd.model.stageAbstractions.Enemy;

public class LazyStrategy extends Strategy {

    public LazyStrategy(Enemy givenEnemy, int vision) {
        super(givenEnemy, vision);
    }
}
