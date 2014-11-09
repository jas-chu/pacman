package com.tdd.application.main;

import com.tdd.application.gameAbstractions.Game;
import com.tdd.application.configuration.LevelConfigurations;
import com.tdd.application.game.ActualGame;
import com.tdd.application.gameAbstractions.GameLevelFactory;
import com.tdd.model.helpers.XMLConstants;
import com.tdd.model.helpers.XMLIO;
import com.tdd.model.helpers.XMLReader;
import com.tdd.model.languageTools.SpanishXMLConstants;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.NodeList;

public class Application {
	
	private Game game;
	
	public Application(String xmlGamePath) {
		XMLConstants gameConstants = new SpanishXMLConstants();
		XMLIO.configureLanguage(gameConstants);
		
		List<GameLevelFactory> levelFactories = this.createLevels(xmlGamePath, gameConstants);
		this.game = new ActualGame(levelFactories);
	}
	
	private List<GameLevelFactory> createLevels(String xmlGamePath, XMLConstants gameConstants) {
		NodeList levelNodes = XMLReader.getNodeByName(xmlGamePath, XMLConstants.LEVEL);
		
		List<GameLevelFactory> factories = new ArrayList<GameLevelFactory>();
		
		for (int i = 0 ; i < levelNodes.getLength() ; ++i) {
			// TO DO
		}
		
		return factories;
	}
	
	public void run() {
		this.game.gameLoop();
	}
	
}
