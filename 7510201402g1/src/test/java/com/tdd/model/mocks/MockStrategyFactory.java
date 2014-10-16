package com.tdd.model.mocks;

import com.tdd.application.gameAbstractions.GameConfigurations;
import com.tdd.model.exceptions.NoAvailableFactoryException;
import com.tdd.model.ghost.Strategy;
import com.tdd.model.helpers.XMLConstants;
import com.tdd.model.languageTools.SpanishXMLConstants;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.strategyFactory.StrategyFactory;
import com.tdd.model.strategyFactory.StrategyFactorySearcher;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 *
 */
public class MockStrategyFactory {

    private StrategyFactorySearcher searcher;
    private String factoryName;

    public MockStrategyFactory(String factoryName) {
        XMLConstants xMLConstants = new SpanishXMLConstants();
        GameConfigurations gameConfigurations = new GameConfigurations(xMLConstants);
        int ghostVision = gameConfigurations.ghostVision;
        int ghostIncrementalVision = gameConfigurations.ghostIncrementalVision;
        this.searcher = new StrategyFactorySearcher(ghostVision, ghostIncrementalVision);
        this.factoryName = factoryName;
    }

    public StrategyFactory getStrategyFactory() {
        try {
            return this.searcher.getFactory(this.factoryName);
        } catch (NoAvailableFactoryException ex) {
            Logger.getLogger(MockStrategyFactory.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }

}
