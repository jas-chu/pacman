package com.tdd.model.strategyFactory;

import com.tdd.model.exceptions.NoAvailableFactoryException;
import com.tdd.model.helpers.XMLConstants;
import java.util.HashMap;

public class StrategyFactorySearcher {

    private int vision;
    private int incrementalVision;

    public static final String LAZY = XMLConstants.LAZY_STRATEGY;
    public static final String SILLY = XMLConstants.SILLY_STRATEGY;
    public static final String NORMAL_SEARCHER = XMLConstants.STRATEGY_NORMAL_SEARCHER;
    public static final String TEMPERAMENT_SEARCHER = XMLConstants.STRATEGY_TEMPERAMENT_SEARCHER;

    private final HashMap<String, StrategyFactory> factorySearcher;

    public StrategyFactorySearcher() {
        this.factorySearcher = new HashMap();
        this.factorySearcher.put(LAZY, new LazyStrategyFactory(this.vision));
        this.factorySearcher.put(SILLY, new SillyStrategyFactory(this.vision));
        this.factorySearcher.put(NORMAL_SEARCHER, new StrategyNormalSearcherFactory(this.vision));
        this.factorySearcher.put(TEMPERAMENT_SEARCHER, new StrategyTemperamentSearcherFactory(this.vision, this.incrementalVision));
    }

    public StrategyFactory getFactory(String name) throws NoAvailableFactoryException {
        if (this.factorySearcher.containsKey(name)) {
            return this.factorySearcher.get(name);
        }
        throw new NoAvailableFactoryException();
    }

}
