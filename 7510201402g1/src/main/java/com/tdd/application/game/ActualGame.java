package com.tdd.application.game;

import com.tdd.application.gameAbstractions.GameLevelFactory;
import com.tdd.application.gameAbstractions.PacmanGame;
import com.tdd.application.gameAbstractions.GameLevel;
import com.tdd.controller.playerController.KeyboardPlayerController;
import com.tdd.model.exceptions.MalformedXMLException;
import com.tdd.model.stage.Pacman;
import com.tdd.model.stageAbstractions.Protagonist;
import com.tdd.view.manager.ViewManager;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ActualGame implements PacmanGame {

    private Protagonist protagonist;
    private List<GameLevelFactory> levelFactories;
    private ViewManager viewManager;
    private KeyboardPlayerController keyboardController;

    public ActualGame(List<GameLevelFactory> givenLevelFactories, ViewManager viewManager) {
        this.protagonist = new Pacman();
        this.levelFactories = givenLevelFactories;
        this.viewManager = viewManager;
        this.keyboardController = new KeyboardPlayerController();

    }

    @Override
    public void gameLoop() {
        while (this.protagonist.isAlive()) {
            this.viewManager.addController(keyboardController);
            int i = 0;
            while (i < this.levelFactories.size() && this.protagonist.isAlive()) {
                try {
                    GameLevelFactory levelFactory = this.levelFactories.get(i);
                    GameLevel level = levelFactory.createLevel();
                    level.setViewManager(this.viewManager);
                    level.populateWithProtagonist(this.protagonist, this.keyboardController);
                    level.levelLoop();
                } catch (MalformedXMLException ex) {
                    Logger.getLogger(ActualGame.class.getName()).log(Level.SEVERE, null, ex);
                }
                ++i;
                this.viewManager.reset();
            }
        }
    }

}
