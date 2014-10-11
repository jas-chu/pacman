package com.tdd.model.strategyFactory;

import com.tdd.model.ghost.Strategy;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.strategy.StrategyNormalSearcher;

public class StrategyNormalSearcherFactory implements StrategyFactory {

    /**
	 * @param givenEnemy
     * @return Devuelve una instancia de la estrategia StrategyNormalSearcher
     */
    @Override
    public Strategy getStrategy(Enemy givenEnemy) {
        return new StrategyNormalSearcher(givenEnemy);
    }

}
