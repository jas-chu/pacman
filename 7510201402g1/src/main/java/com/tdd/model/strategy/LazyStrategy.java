package com.tdd.model.strategy;

import com.tdd.model.ghost.Strategy;
import com.tdd.model.helpers.XMLConstants;
import com.tdd.model.stageAbstractions.Enemy;

public class LazyStrategy extends Strategy {

    public LazyStrategy(Enemy givenEnemy, int vision) {
        super(givenEnemy, vision);
    }
    
    @Override
    public String toString(){
        return XMLConstants.LAZY_STRATEGY;
    }
}
