package com.tdd.model.strategy;

import com.tdd.model.stageAbstractions.Enemy;

public class StrategyNormalSearcher extends StrategySearchers {

    public StrategyNormalSearcher(Enemy givenEnemy, int vision) {
        super(givenEnemy, vision);
    }

}
