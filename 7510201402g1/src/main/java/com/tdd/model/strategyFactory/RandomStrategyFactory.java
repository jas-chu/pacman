package com.tdd.model.strategyFactory;

import com.tdd.model.stageAbstractions.MovedByStrategy;
import com.tdd.model.stageAbstractions.Strategy;
import com.tdd.model.stageAbstractions.StrategyFactory;

public class RandomStrategyFactory implements StrategyFactory {
	
	@Override
	public Strategy getStrategy(MovedByStrategy givenElement) {
		throw new UnsupportedOperationException("Not supported yet.");
	}

}
