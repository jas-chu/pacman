package com.tdd.application.main;

import com.tdd.application.gameAbstractions.PacmanGame;
import com.tdd.application.game.ActualGame;
import com.tdd.application.gameAbstractions.GameLevel;
import com.tdd.application.gameAbstractions.GameLevelFactory;
import com.tdd.application.gameLevelFactory.GameLevelFactorySearcher;
import com.tdd.controller.controllerAbstractions.Controller;
import com.tdd.controller.playerController.KeyboardPlayerController;
import com.tdd.model.exceptions.NoAvailableFactoryException;
import com.tdd.model.helpers.XMLConstants;
import com.tdd.model.helpers.XMLIO;
import com.tdd.model.helpers.XMLReader;
import com.tdd.model.languageTools.SpanishXMLConstants;
import com.tdd.view.manager.ViewManager;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.NodeList;

public class Application {

    private PacmanGame game;
    private ViewManager view;
    private String name;
    private Controller controller;

    public Application(String name, String xmlGamePath) throws NoAvailableFactoryException {
        XMLConstants gameConstants = new SpanishXMLConstants();
        XMLIO.configureLanguage(gameConstants);
        this.name = name;
        List<GameLevelFactory> levelFactories = this.createLevels(xmlGamePath, gameConstants);
        this.view = ViewManager.getInstance();
        this.view.createWindow(name);
        this.game = new ActualGame(levelFactories,this.view);
        
        this.controller = new KeyboardPlayerController(this.view, this.game);
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

    public void run() {
        this.game.gameLoop();
    }

    public void show() {
        this.view.showWindow();
    }

}
