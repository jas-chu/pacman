package com.tdd.model.strategyFactory;

import com.tdd.model.stageAbstractions.Strategy;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.strategy.SillyStrategy;

public class SillyStrategyFactory implements StrategyFactory {
    private int vision;

    public SillyStrategyFactory(int vision){
        this.vision = vision;     
    }   
    
    /**
	 * @param givenEnemy
     * @return Devuelve instancia de la estrategy SillyStrategy
     */
    @Override
    public Strategy getStrategy(com.tdd.model.stageAbstractions.MovedByStrategy givenElement) {
        return new SillyStrategy(givenElement, this.vision);
    }

}
