package com.tdd.model.strategyFactory;

import com.tdd.model.stageAbstractions.MovedByStrategy;
import com.tdd.model.stageAbstractions.Strategy;

public interface StrategyFactory {
	
    // Returns an instance of the corresponding strategy
    public Strategy getStrategy(MovedByStrategy givenElement);
    
}
