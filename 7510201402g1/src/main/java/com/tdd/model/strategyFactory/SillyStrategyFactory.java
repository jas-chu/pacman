package com.tdd.model.strategyFactory;

import com.tdd.model.stageAbstractions.StrategyFactory;
import com.tdd.model.stageAbstractions.Strategy;
import com.tdd.model.stageAbstractions.MovedByStrategy;
import com.tdd.model.strategy.SillyStrategy;

public class SillyStrategyFactory implements StrategyFactory {
    private int vision;

    public SillyStrategyFactory(int vision){
        this.vision = vision;     
    }   
    
    /**
	 * @param givenElement
     * @return Devuelve instancia de la estrategy SillyStrategy
     */
    @Override
    public Strategy getStrategy(MovedByStrategy givenElement) {
        return new SillyStrategy(givenElement, this.vision);
    }

}
