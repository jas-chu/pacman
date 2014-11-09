package com.tdd.application.main;

import com.tdd.application.gameAbstractions.PacmanGame;
import com.tdd.application.game.ActualGame;
import com.tdd.application.gameAbstractions.GameLevelFactory;
import com.tdd.application.gameLevelFactory.GameLevelFactorySearcher;
import com.tdd.model.exceptions.NoAvailableFactoryException;
import com.tdd.model.helpers.XMLConstants;
import com.tdd.model.helpers.XMLIO;
import com.tdd.model.helpers.XMLReader;
import com.tdd.model.languageTools.SpanishXMLConstants;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.NodeList;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class Application extends StateBasedGame {

    private PacmanGame game;
    private AppGameContainer container;

    public Application(String name, String xmlGamePath) throws SlickException, NoAvailableFactoryException {
        super(name);
        XMLConstants gameConstants = new SpanishXMLConstants();
        XMLIO.configureLanguage(gameConstants);

        List<GameLevelFactory> levelFactories = this.createLevels(xmlGamePath, gameConstants);
        this.game = new ActualGame(levelFactories);
        this.container = new AppGameContainer(this, 800, 600, false);
        this.container.setShowFPS(false);
        this.container.start();
    }

    private List<GameLevelFactory> createLevels(String xmlGamePath, XMLConstants gameConstants) throws NoAvailableFactoryException {
		NodeList levelNodes = XMLReader.getNodeByName(xmlGamePath, XMLConstants.LEVEL);
		
		GameLevelFactorySearcher levelFactorySearcher = new GameLevelFactorySearcher();
		List<GameLevelFactory> factories = new ArrayList<GameLevelFactory>();
		
		for (int i = 0 ; i < levelNodes.getLength() ; ++i) {
			GameLevelFactory levelFactory = levelFactorySearcher.getFactory(levelNodes.item(i), gameConstants);
			factories.add(levelFactory);
		}
		
		return factories;
	}

    public void run() {
        this.game.gameLoop();
    }

    @Override
    public void initStatesList(GameContainer gc) throws SlickException {
        
    }
	
}
