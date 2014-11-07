package com.tdd.model.strategyFactory;

import com.tdd.model.stageAbstractions.StrategyFactory;
import com.tdd.model.stageAbstractions.Strategy;
import com.tdd.model.stageAbstractions.MovedByStrategy;
import com.tdd.model.strategy.StrategyTemperamentSearcher;

public class StrategyTemperamentSearcherFactory implements StrategyFactory {

    private int vision;
    private int incrementalVision;

    public StrategyTemperamentSearcherFactory(int vision, int incrementalVision){
        this.vision = vision;
        this.incrementalVision = incrementalVision;
    }
    
    /**
	 * @param givenElement
     * @return Devuelve una instancia de la estrategy
     * StrategyTemperamentSeacher.
     */
    @Override
    public Strategy getStrategy(MovedByStrategy givenElement) {
        return new StrategyTemperamentSearcher(givenElement, this.vision, this.incrementalVision);
    }
}
