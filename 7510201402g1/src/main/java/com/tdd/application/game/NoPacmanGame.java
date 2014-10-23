package com.tdd.application.game;

import com.tdd.application.gameAbstractions.Game;
import com.tdd.application.gameAbstractions.GameConfigurations;
import com.tdd.controller.controllerAbstractions.PlayerController;
import com.tdd.controller.playerController.NoPlayerController;
import com.tdd.model.exceptions.MalformedXMLException;

public class NoPacmanGame extends Game {
	
	private long ticksToRun;
	
	public NoPacmanGame(GameConfigurations givenConfigs, long givenTicksToRun) throws MalformedXMLException {
		super(givenConfigs);
		this.ticksToRun = givenTicksToRun;
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
	public boolean isEndOfGame() {
		return (this.ticksToRun == this.ticks);
	}

}
