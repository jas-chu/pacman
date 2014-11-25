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
import com.tdd.view.manager.ViewManager;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.NodeList;

public class Application implements Runnable{

    private PacmanGame game;
    private ViewManager view;
    
    public Application(String name, String xmlGamePath) throws NoAvailableFactoryException {
        XMLConstants gameConstants = new SpanishXMLConstants();
        XMLIO.configureLanguage(gameConstants);
        List<GameLevelFactory> levelFactories = this.createLevels(xmlGamePath, gameConstants);
        this.view = ViewManager.getInstance();
        this.view.createWindow(name);
        this.game = new ActualGame(levelFactories, this.view);
    }

    private List<GameLevelFactory> createLevels(String xmlGamePath, XMLConstants gameConstants) throws NoAvailableFactoryException {
        NodeList levelNodes = XMLReader.getNodeByName(xmlGamePath, XMLConstants.LEVEL);

        GameLevelFactorySearcher levelFactorySearcher = new GameLevelFactorySearcher();
        List<GameLevelFactory> factories = new ArrayList<GameLevelFactory>();

        for (int i = 0; i < levelNodes.getLength(); ++i) {
            GameLevelFactory levelFactory = levelFactorySearcher.getFactory(levelNodes.item(i), gameConstants);
            factories.add(levelFactory);
        }

        return factories;
    }

    @Override
    public void run() {
        this.view.showWindow();
		MyThread thread = new MyThread(this.game);
        thread.start();
    }
	
	private class MyThread extends Thread {
		
		private PacmanGame myGame;
		
		public MyThread(PacmanGame givenGame) {
			this.myGame = givenGame;
		}
		
		@Override
		public void run() {
			this.myGame.gameLoop();
		}
	}

}
