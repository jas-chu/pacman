package com.tdd.model.strategyFactory;

import com.tdd.model.stageAbstractions.MovedByStrategy;
import com.tdd.model.stageAbstractions.StrategyFactory;
import com.tdd.model.stageAbstractions.Strategy;
import com.tdd.model.strategy.LazyStrategy;

public class LazyStrategyFactory implements StrategyFactory {
    private int vision;
    
    public LazyStrategyFactory(int vision){
        this.vision = vision;     
    }
    
    /**
	 * @param givenElement
     * @return Devuelve una instancia de la estrategia LazyStrategy.
     */
    @Override
    public Strategy getStrategy(MovedByStrategy givenElement) {
        return new LazyStrategy(givenElement, this.vision);
    }

}
