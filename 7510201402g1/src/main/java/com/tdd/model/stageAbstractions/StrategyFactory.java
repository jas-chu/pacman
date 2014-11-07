package com.tdd.model.stageAbstractions;

public interface StrategyFactory {
	
    // Returns an instance of the corresponding strategy
    public Strategy getStrategy(MovedByStrategy givenElement);
    
}
