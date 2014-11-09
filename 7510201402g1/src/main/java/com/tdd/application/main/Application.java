package com.tdd.application.main;

import com.tdd.application.gameAbstractions.Game;
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

public class Application {
	
	private Game game;
	
	public Application(String xmlGamePath) throws NoAvailableFactoryException {
		XMLConstants gameConstants = new SpanishXMLConstants();
		XMLIO.configureLanguage(gameConstants);
		
		List<GameLevelFactory> levelFactories = this.createLevels(xmlGamePath, gameConstants);
		this.game = new ActualGame(levelFactories);
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
	
}
