package com.tdd.model.strategyFactory;

import com.tdd.model.stageAbstractions.Strategy;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.strategy.LazyStrategy;

public class LazyStrategyFactory implements StrategyFactory {
    private int vision;
    
    public LazyStrategyFactory(int vision){
        this.vision = vision;     
    }
    
    /**
	 * @param givenEnemy
     * @return Devuelve una instancia de la estrategia LazyStrategy.
     */
    @Override
    public Strategy getStrategy(com.tdd.model.stageAbstractions.MovedByStrategy givenElement) {
        return new LazyStrategy(givenElement, this.vision);
    }

}
