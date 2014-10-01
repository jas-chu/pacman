package com.tdd.model.strategyFactory;

import com.tdd.model.ghost.Strategy;
import com.tdd.model.strategy.StrategySearcher;

public class StrategySearcherFactory implements StrategyFactory {

    /**
     * @return Devuelve una instancia de la estrategia StrategySearcher
     */
    @Override
    public Strategy getStrategy() {
        return new StrategySearcher();
    }

}
