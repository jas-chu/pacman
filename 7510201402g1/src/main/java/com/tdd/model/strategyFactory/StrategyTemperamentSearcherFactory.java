package com.tdd.model.strategyFactory;

import com.tdd.model.ghost.Strategy;
import com.tdd.model.strategy.StrategyTemperamentSearcher;

public class StrategyTemperamentSearcherFactory implements StrategyFactory{

    /**
     * @return Devuelve una instancia de la estrategy StrategyTemperamentSeacher.
     */
    @Override
    public Strategy getStrategy(){
        return new StrategyTemperamentSearcher();
    }
}
