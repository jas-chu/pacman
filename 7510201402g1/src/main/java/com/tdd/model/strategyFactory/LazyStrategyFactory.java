package com.tdd.model.strategyFactory;

import com.tdd.model.ghost.Strategy;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.strategy.LazyStrategy;

public class LazyStrategyFactory implements StrategyFactory {
    private int vision;
    /**
	 * @param givenEnemy
     * @return Devuelve una instancia de la estrategia LazyStrategy.
     */
    @Override
    public Strategy getStrategy(Enemy givenEnemy) {
        return new LazyStrategy(givenEnemy, this.vision);
    }

}
