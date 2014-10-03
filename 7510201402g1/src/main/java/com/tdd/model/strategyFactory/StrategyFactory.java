package com.tdd.model.strategyFactory;

import com.tdd.model.ghost.Strategy;
import com.tdd.model.stageAbstractions.Enemy;

public interface StrategyFactory {
    // Devuelve una instancia de la estrategia correspondiente.
    public Strategy getStrategy(Enemy givenEnemy);
    
}
