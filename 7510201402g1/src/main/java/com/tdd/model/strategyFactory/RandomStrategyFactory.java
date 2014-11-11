package com.tdd.model.strategyFactory;

import com.tdd.model.stageAbstractions.MovedByStrategy;
import com.tdd.model.stageAbstractions.Strategy;
import com.tdd.model.stageAbstractions.StrategyFactory;
import com.tdd.model.strategy.RandomStrategy;

public class RandomStrategyFactory implements StrategyFactory {

    public RandomStrategyFactory() {
    }

    /**
     * @param givenElement
     * @return Devuelve una instancia de la estrategia RandomStrategy.
     */
    @Override
    public Strategy getStrategy(MovedByStrategy givenElement) {
        return new RandomStrategy(givenElement);
    }
}
