package com.tdd.application.game;

import com.tdd.application.gameAbstractions.GameLevelFactory;
import com.tdd.application.gameAbstractions.PacmanGame;
import com.tdd.application.gameAbstractions.GameLevel;
import com.tdd.model.exceptions.MalformedXMLException;
import com.tdd.model.stage.Pacman;
import com.tdd.model.stageAbstractions.Protagonist;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.newdawn.slick.*;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class ActualGame extends BasicGameState implements PacmanGame {

    private Protagonist protagonist;
    private List<GameLevelFactory> levelFactories;

    public ActualGame(List<GameLevelFactory> givenLevelFactories) {
        this.protagonist = new Pacman();
        this.levelFactories = givenLevelFactories;
    }

    @Override
    public void gameLoop() {
        while (this.protagonist.isAlive()) {
            int i = 0;
            while (i < this.levelFactories.size() && this.protagonist.isAlive()) {
                try {
                    GameLevelFactory levelFactory = this.levelFactories.get(i);
                    GameLevel level = levelFactory.createLevel();
                    level.populateWithProtagonist(this.protagonist);
                    level.levelLoop();
                } catch (MalformedXMLException ex) {
                    Logger.getLogger(ActualGame.class.getName()).log(Level.SEVERE, null, ex);
                }
                ++i;
            }
        }
    }

    @Override
    public int getID() {
        return 0;
    }

    @Override
    public void init(GameContainer gc, StateBasedGame sbg) throws SlickException {
    }

    @Override
    public void render(GameContainer gc, StateBasedGame sbg, Graphics grphcs) throws SlickException {
        grphcs.drawOval(100, 100, 200, 200);
    }

    @Override
    public void update(GameContainer gc, StateBasedGame sbg, int i) throws SlickException {
    }

}
