package com.tdd.model.strategyFactory;

import java.util.HashMap;

public class StrategyFactorySearcher {
    public int vision;
    public int incrementalVision;

    public enum StrategyName {

        LAZYSTRATEGY, SILLYSTRATEGY, STRATEGYNORMALSEARCHER, STRATEGYTEMPERAMENTSEARCHER;
    }

    private final HashMap<StrategyName, StrategyFactory> factorySearcher;

    public StrategyFactorySearcher() {
        this.factorySearcher = new HashMap();
        this.factorySearcher.put(StrategyName.LAZYSTRATEGY, new LazyStrategyFactory(this.vision));
        this.factorySearcher.put(StrategyName.SILLYSTRATEGY, new SillyStrategyFactory(this.vision));
        this.factorySearcher.put(StrategyName.STRATEGYNORMALSEARCHER, new StrategyNormalSearcherFactory(this.vision));
        this.factorySearcher.put(StrategyName.STRATEGYTEMPERAMENTSEARCHER, new StrategyTemperamentSearcherFactory(this.vision, this.incrementalVision));
    }

    public StrategyFactory getFactory(StrategyName name) {
        return this.factorySearcher.get(name);
    }

}
