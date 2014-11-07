package com.tdd.model.strategyFactory;

import com.tdd.model.stageAbstractions.Strategy;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.strategy.StrategyTemperamentSearcher;

public class StrategyTemperamentSearcherFactory implements StrategyFactory {

    private int vision;
    private int incrementalVision;

    public StrategyTemperamentSearcherFactory(int vision, int incrementalVision){
        this.vision = vision;
        this.incrementalVision = incrementalVision;
    }
    
    /**
     * @param givenEnemy
     * @return Devuelve una instancia de la estrategy
     * StrategyTemperamentSeacher.
     */
    @Override
    public Strategy getStrategy(com.tdd.model.stageAbstractions.MovedByStrategy givenElement) {
        return new StrategyTemperamentSearcher(givenElement, this.vision, this.incrementalVision);
    }
}
