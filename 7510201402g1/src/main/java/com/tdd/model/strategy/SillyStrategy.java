package com.tdd.model.strategy;

import com.tdd.model.stageAbstractions.Direction;
import com.tdd.model.ghost.Strategy;
import com.tdd.model.stageAbstractions.Enemy;

public class SillyStrategy extends Strategy {

    public SillyStrategy(Enemy givenEnemy) {
        super(givenEnemy);
    }

    @Override
    public void advanceCycle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
