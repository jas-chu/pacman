package com.tdd.model.strategyFactory;

import java.util.HashMap;

public class StrategyFactorySearcher {

    public enum StrategyName {
        LAZYSTRATEGY, SILLYSTRATEGY, STRATEGYNORMALSEARCHER, STRATEGYTEMPERAMENTSEARCHER;
    }

    private final HashMap<StrategyName, StrategyFactory> factorySearcher;

    public StrategyFactorySearcher() {
        this.factorySearcher = new HashMap();
        this.factorySearcher.put(StrategyName.LAZYSTRATEGY, new LazyStrategyFactory());
        this.factorySearcher.put(StrategyName.SILLYSTRATEGY, new SillyStrategyFactory());
        this.factorySearcher.put(StrategyName.STRATEGYNORMALSEARCHER, new StrategyNormalSearcherFactory());
        this.factorySearcher.put(StrategyName.STRATEGYTEMPERAMENTSEARCHER, new StrategyNormalSearcherFactory());
    }

    public StrategyFactory getFactory(StrategyName name) {
        return this.factorySearcher.get(name);
    }

}
