package com.tdd.model.strategyFactory;

import com.tdd.model.ghost.Strategy;
import java.util.HashMap;

public class StrategyFactorySearcher {

    private HashMap<String, Strategy> factorySearcher;

    public StrategyFactorySearcher() {
        this.factorySearcher = new HashMap();
    }

}
