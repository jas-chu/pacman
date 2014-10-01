package com.tdd.model.strategyFactory;

import java.util.HashMap;

public class StrategyFactorySearcher {

    public enum StrategyName {
        LAZYSTRATEGY, SILLYSTRATEGY, STRATEGYSEARCHER, STRATEGYTEMPERAMENTSEARCHER;
    }

    private final HashMap<StrategyName, StrategyFactory> factorySearcher;

    public StrategyFactorySearcher() {
        this.factorySearcher = new HashMap();
        this.factorySearcher.put(StrategyName.LAZYSTRATEGY, new LazyStrategyFactory());
        this.factorySearcher.put(StrategyName.SILLYSTRATEGY, new SillyStrategyFactory());
        this.factorySearcher.put(StrategyName.STRATEGYSEARCHER, new StrategySearcherFactory());
        this.factorySearcher.put(StrategyName.STRATEGYTEMPERAMENTSEARCHER, new StrategySearcherFactory());
    }

    public StrategyFactory getFactory(StrategyName name) {
        return this.factorySearcher.get(name);
    }

}
