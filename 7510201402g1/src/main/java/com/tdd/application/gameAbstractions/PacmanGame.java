package com.tdd.application.gameAbstractions;

import com.tdd.controller.playerController.KeyboardPlayerController;
import com.tdd.model.exceptions.MalformedXMLException;
import com.tdd.model.stage.Pacman;
import com.tdd.model.stageAbstractions.Protagonist;
import com.tdd.view.manager.ViewManager;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public class PacmanGame {

    private Protagonist protagonist;
    private List<GameLevelFactory> levelFactories;
    private ViewManager viewManager;
    private KeyboardPlayerController keyboardController;

    public PacmanGame(List<GameLevelFactory> givenLevelFactories, ViewManager givenViewManager) {
        this.protagonist = new Pacman();
        this.levelFactories = givenLevelFactories;
        this.viewManager = givenViewManager;
        this.keyboardController = new KeyboardPlayerController();
    }

    public void gameLoop() {
        while (this.protagonist.isAlive()) {
            if (this.viewManager != null) this.viewManager.addController(keyboardController);
            int i = 0;
            while (i < this.levelFactories.size() && this.protagonist.isAlive()) {
                try {
                    GameLevelFactory levelFactory = this.levelFactories.get(i);
                    GameLevel level = levelFactory.createLevel();
                    level.setViewManager(this.viewManager);
                    level.populateWithProtagonist(this.protagonist, this.keyboardController);
                    level.levelLoop();
                } catch (MalformedXMLException ex) {
                    Logger.getLogger(PacmanGame.class.getName()).log(Level.SEVERE, null, ex);
                }
                ++i;
                if (this.viewManager != null) this.viewManager.reset();
            }
        }
        if (this.viewManager != null) this.viewManager.gameOver();
    }

}
