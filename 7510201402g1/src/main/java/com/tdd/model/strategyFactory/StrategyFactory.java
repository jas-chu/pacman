package com.tdd.model.strategyFactory;

import com.tdd.model.ghost.Strategy;

public interface StrategyFactory {
    // Devuelve una instancia de la estrategia correspondiente.
    public Strategy getStrategy();
    
}
