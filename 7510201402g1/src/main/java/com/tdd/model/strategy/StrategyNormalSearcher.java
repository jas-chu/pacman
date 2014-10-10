package com.tdd.model.strategy;

import com.tdd.model.stageAbstractions.Enemy;

public class StrategyNormalSearcher extends StrategySearchers {

    public StrategyNormalSearcher(Enemy givenEnemy) {
        super(givenEnemy);
    }

    @Override
    public void advanceCycle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
