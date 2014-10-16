package com.tdd.model.strategyFactory;

import java.util.HashMap;

public class StrategyFactorySearcher {
    private int vision;
    private int incrementalVision;

    public enum StrategyName {

        LAZYSTRATEGY, SILLYSTRATEGY, STRATEGYNORMALSEARCHER, STRATEGYTEMPERAMENTSEARCHER;
    }

    private final HashMap<StrategyName, StrategyFactory> factorySearcher;

    public StrategyFactorySearcher(int givenVision, int givenIncrementalVision) {
		this.vision = givenVision;
		this.incrementalVision = givenIncrementalVision;
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
