package com.tdd.model.strategyFactory;

import com.tdd.model.ghost.Strategy;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.strategy.SillyStrategy;

public class SillyStrategyFactory implements StrategyFactory {

    /**
	 * @param givenEnemy
     * @return Devuelve instancia de la estrategy SillyStrategy
     */
    @Override
    public Strategy getStrategy(Enemy givenEnemy) {
        return new SillyStrategy(givenEnemy);
    }

}
