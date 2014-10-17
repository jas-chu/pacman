package com.tdd.application.game;

import com.tdd.application.gameAbstractions.GameConfigurations;
import com.tdd.model.exceptions.MalformedXMLException;

public class NoEnemiesGame extends XMLConductedGame {

	public NoEnemiesGame(GameConfigurations givenConfigs) throws MalformedXMLException {
		super(givenConfigs);
	}
	
	@Override
	protected void populateMap() throws MalformedXMLException {
		this.createProtagonist();
	}

}
