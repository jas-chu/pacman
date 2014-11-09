package com.tdd.application.gameAbstractions;

import com.tdd.application.configuration.LevelConfigurationsReader;
import com.tdd.model.exceptions.MalformedXMLException;

public abstract class GameLevelFactory {
	
	protected LevelConfigurationsReader configs;
	
	public GameLevelFactory(LevelConfigurationsReader givenConfigs) {
		this.configs = givenConfigs;
	}
	
	public abstract GameLevel createLevel() throws MalformedXMLException;

}
