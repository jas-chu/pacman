package com.tdd.model.strategyFactory;

import com.tdd.model.ghost.Strategy;
import com.tdd.model.strategy.SillyStrategy;

public class SillyStrategyFactory implements StrategyFactory {

    /**
     * @return Devuelve instancia de la estrategy SillyStrategy
     */
    @Override
    public Strategy getStrategy() {
        return new SillyStrategy();
    }

}
