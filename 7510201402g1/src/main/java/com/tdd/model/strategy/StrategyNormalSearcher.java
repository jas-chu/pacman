package com.tdd.model.strategy;

import com.tdd.model.helpers.XMLConstants;
import com.tdd.model.stageAbstractions.Enemy;

public class StrategyNormalSearcher extends StrategySearchers {

    public StrategyNormalSearcher(Enemy givenEnemy, int vision) {
        super(givenEnemy, vision);
    }

    @Override
    public String toString() {
        return XMLConstants.STRATEGY_NORMAL_SEARCHER;
    }

}
