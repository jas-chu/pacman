package com.tdd.application.gameAbstractions;

import com.tdd.model.exceptions.MalformedXMLException;

public abstract class GameLevelFactory {
	
	protected GameConfigurationsReader configs;
	protected String XMLStagePath;
	protected String XMLCharactersPath;
	
	public GameLevelFactory(GameConfigurationsReader givenConfigs, String givenXMLStagePath, String givenXMLCharactersPath) {
		this.configs = givenConfigs;
		this.XMLStagePath = givenXMLStagePath;
		this.XMLCharactersPath = givenXMLCharactersPath;
	}
	
	public abstract GameLevel createLevel() throws MalformedXMLException;

}
