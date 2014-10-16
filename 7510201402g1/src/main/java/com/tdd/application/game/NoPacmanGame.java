package com.tdd.application.game;

import com.tdd.application.gameAbstractions.Game;
import com.tdd.application.gameAbstractions.GameConfigurations;
import com.tdd.controller.controllerAbstractions.PlayerController;
import com.tdd.controller.playerController.NoPlayerController;
import com.tdd.model.exceptions.MalformedXMLException;

public class NoPacmanGame extends Game {
	
	private long ticks;
	
	public NoPacmanGame(GameConfigurations givenConfigs, long givenTicks) throws MalformedXMLException {
		super(givenConfigs);
		this.ticks = givenTicks;
	}

	@Override
	protected PlayerController createPlayerController() {
		return new NoPlayerController();
	}
	
	@Override
	protected void populateMap() throws MalformedXMLException {
		this.createEnemies();
	}
	
	@Override
	protected boolean isEndOfGame() {
		this.ticks--;
		return (this.ticks <= 0);
	}

}
