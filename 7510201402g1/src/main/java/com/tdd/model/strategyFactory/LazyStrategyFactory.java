package com.tdd.model.strategyFactory;

import com.tdd.model.ghost.Strategy;
import com.tdd.model.strategy.LazyStrategy;

public class LazyStrategyFactory implements StrategyFactory {

    /** 
     * @return Devuelve una instancia de la estrategia LazyStrategy.
     */
    @Override
    public Strategy getStrategy() {
        return new LazyStrategy();
    }

}
