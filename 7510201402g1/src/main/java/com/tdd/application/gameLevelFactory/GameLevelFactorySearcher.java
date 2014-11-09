package com.tdd.application.gameLevelFactory;

import com.tdd.application.configuration.LevelConfigurations;
import com.tdd.application.gameAbstractions.GameLevelFactory;
import com.tdd.model.exceptions.NoAvailableFactoryException;
import com.tdd.model.exceptions.NotMyJobException;
import com.tdd.model.helpers.XMLConstants;
import com.tdd.model.helpers.XMLReader;
import java.util.ArrayList;
import java.util.List;
import javax.management.AttributeNotFoundException;
import org.w3c.dom.Node;

public class GameLevelFactorySearcher {
	
	private List<GameLevelFactory> availableFactories;

    public GameLevelFactorySearcher() {
        this.availableFactories = new ArrayList<GameLevelFactory>();
		this.availableFactories.add(new KeyboardConductedLevelFactory());
        this.availableFactories.add(new XMLConductedLevelFactory());
        this.availableFactories.add(new NoPacmanLevelFactory());
    }

    /**
     * Gets a new GameLevelFactory that corresponds with the levelNode.
	 * @param gameConstants
	 * @param levelNode
     * @return
	 * @throws com.tdd.model.exceptions.NoAvailableFactoryException
     */
    public GameLevelFactory getFactory(Node levelNode, XMLConstants gameConstants) throws NoAvailableFactoryException {
		LevelConfigurations levelConfigs = new LevelConfigurations(gameConstants, levelNode);
		String levelType = this.getLevelType(levelNode, gameConstants);
		
		for (GameLevelFactory factory : this.availableFactories) {
			try {
				factory.testCreateFactory(levelType);
				return factory.createFactory(levelConfigs);
			} catch (NotMyJobException e) {
				// move on to next factory
			}
		}
        throw new NoAvailableFactoryException();
    }

	private String getLevelType(Node levelNode, XMLConstants gameConstants) throws NoAvailableFactoryException {
		try {
			String type = XMLReader.getAttributeValue(levelNode, XMLConstants.LEVEL_TYPE);
			return gameConstants.getInvertedLevelTypeValueTranslation(type);
		} catch (AttributeNotFoundException ex) {
			throw new NoAvailableFactoryException();
		}
	}
	
}
