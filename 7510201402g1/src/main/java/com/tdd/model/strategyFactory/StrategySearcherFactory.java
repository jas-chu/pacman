package com.tdd.model.strategyFactory;

import com.tdd.model.ghost.Strategy;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.strategy.StrategySearcher;

public class StrategySearcherFactory implements StrategyFactory {

    /**
	 * @param givenEnemy
     * @return Devuelve una instancia de la estrategia StrategySearcher
     */
    @Override
    public Strategy getStrategy(Enemy givenEnemy) {
        return new StrategySearcher(givenEnemy);
    }

}
