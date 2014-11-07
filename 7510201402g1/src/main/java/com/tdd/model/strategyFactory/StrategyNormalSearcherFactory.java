package com.tdd.model.strategyFactory;

import com.tdd.model.stageAbstractions.Strategy;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.strategy.StrategyNormalSearcher;

public class StrategyNormalSearcherFactory implements StrategyFactory {

    private int vision;
    
    public StrategyNormalSearcherFactory(int vision){
        this.vision = vision;     
    }

    /**
     * @param givenEnemy
     * @return Devuelve una instancia de la estrategia StrategyNormalSearcher
     */
    @Override
    public Strategy getStrategy(com.tdd.model.stageAbstractions.MovedByStrategy givenElement) {
        return new StrategyNormalSearcher(givenElement, this.vision);
    }

}
