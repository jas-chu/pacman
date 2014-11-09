package com.tdd.model.mocks;

import com.tdd.application.gameAbstractions.GameConfigurations;
import com.tdd.application.gameAbstractions.GameConfigurationsReader;
import com.tdd.model.exceptions.NoAvailableFactoryException;
import com.tdd.model.stageAbstractions.Strategy;
import com.tdd.model.helpers.XMLConstants;
import com.tdd.model.languageTools.SpanishXMLConstants;
import com.tdd.model.stageAbstractions.MovedByStrategy;
import com.tdd.model.stageAbstractions.StrategyFactory;
import com.tdd.model.strategyFactory.StrategyFactorySearcher;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 *
 */
public class MockStrategyFactory implements StrategyFactory {

    private StrategyFactorySearcher searcher;
    private String factoryName;

    public MockStrategyFactory(String factoryName) {
        XMLConstants xMLConstants = new SpanishXMLConstants();
        GameConfigurationsReader gameConfigurations = new GameConfigurations(xMLConstants);
        int ghostVision = gameConfigurations.getGhostVision();
        int ghostIncrementalVision = gameConfigurations.getGhostIncrementalVision();
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

	@Override
	public Strategy getStrategy(MovedByStrategy givenElement) {
		return new MockStrategy();
	}

}
