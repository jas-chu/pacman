package com.tdd.model.strategy;

import com.tdd.model.helpers.XMLConstants;
import com.tdd.model.stageAbstractions.MovedByStrategy;

public class StrategyNormalSearcher extends StrategySearchers {

    public StrategyNormalSearcher(MovedByStrategy givenElement, int vision) {
        super(givenElement, vision);
    }

    @Override
    public String toString() {
        return XMLConstants.STRATEGY_NORMAL_SEARCHER;
    }

}
