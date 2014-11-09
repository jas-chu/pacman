package com.tdd.application.gameLevelFactory;

import com.tdd.application.game.XMLConductedLevel;
import com.tdd.application.configuration.LevelConfigurationsReader;
import com.tdd.application.gameAbstractions.GameLevel;
import com.tdd.application.gameAbstractions.GameLevelFactory;
import com.tdd.model.exceptions.MalformedXMLException;
import com.tdd.model.helpers.XMLConstants;

public class XMLConductedLevelFactory extends GameLevelFactory {
	
	public XMLConductedLevelFactory() {
		super();
	}
	
	private XMLConductedLevelFactory(LevelConfigurationsReader givenConfigs) {
		super(givenConfigs);
	}
	
	@Override
	protected String getMyLevelType() {
		return XMLConstants.XML_LEVEL;
	}
	
	@Override
	public GameLevelFactory createFactory(LevelConfigurationsReader givenConfigs) {
		return new XMLConductedLevelFactory(givenConfigs);
	}
	
	@Override
	public GameLevel createLevel() throws MalformedXMLException {
		return new XMLConductedLevel(this.configs);
	}

}
