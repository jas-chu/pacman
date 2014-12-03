package com.tdd.application.gameLevelFactory;

import com.tdd.application.configuration.LevelConfigurations;
import com.tdd.application.gameAbstractions.GameLevelFactory;
import com.tdd.model.exceptions.NoAvailableFactoryException;
import com.tdd.model.helpers.XMLConstants;
import com.tdd.model.helpers.XMLReader;
import java.util.HashMap;
import java.util.Map;
import javax.management.AttributeNotFoundException;
import org.w3c.dom.Node;

public class GameLevelFactorySearcher {

    private Map<String, GameLevelFactory> availableFactories;

    public GameLevelFactorySearcher() {
        this.availableFactories = new HashMap<>();
        this.availableFactories.put(XMLConstants.KEYBOARD_LEVEL, new KeyboardConductedLevelFactory());
        this.availableFactories.put(XMLConstants.XML_LEVEL, new XMLConductedLevelFactory());
        this.availableFactories.put(XMLConstants.NO_PACMAN_LEVEL, new NoPacmanLevelFactory());
    }

    /**
     * Gets a new GameLevelFactory that corresponds with the levelNode.
     *
     * @param gameConstants
     * @param levelNode
     * @return
     * @throws com.tdd.model.exceptions.NoAvailableFactoryException
     */
    public GameLevelFactory getFactory(Node levelNode, XMLConstants gameConstants) throws NoAvailableFactoryException {
        LevelConfigurations levelConfigs = new LevelConfigurations(gameConstants, levelNode);
        String levelType = this.getLevelType(levelNode, gameConstants);

        GameLevelFactory factory = this.availableFactories.get(levelType);
        if (factory == null) {
            throw new NoAvailableFactoryException();
        }
        return factory.createFactory(levelConfigs);
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
