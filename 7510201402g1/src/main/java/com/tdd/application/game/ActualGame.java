package com.tdd.application.game;

import com.tdd.application.gameAbstractions.GameLevelFactory;
import com.tdd.application.gameAbstractions.Game;
import com.tdd.application.gameAbstractions.GameConfigurations;
import com.tdd.application.gameAbstractions.GameLevel;
import com.tdd.model.exceptions.MalformedXMLException;
import com.tdd.model.stage.Pacman;
import com.tdd.model.stageAbstractions.Protagonist;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class ActualGame implements Game {
	
	private GameConfigurations configs;
	private Protagonist protagonist;
	private List<GameLevelFactory> levelFactories;
	
	public ActualGame(GameConfigurations givenConfigs, List<GameLevelFactory> givenLevelFactories) {
		this.configs = givenConfigs;
		this.protagonist = new Pacman();
		this.levelFactories = givenLevelFactories;
	}
	
	@Override
	public void gameLoop() {
		while(this.protagonist.isAlive()) {
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
	
}
