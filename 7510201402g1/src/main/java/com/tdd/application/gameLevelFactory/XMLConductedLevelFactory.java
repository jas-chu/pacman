package com.tdd.application.gameLevelFactory;

import com.tdd.application.game.XMLConductedLevel;
import com.tdd.application.configuration.LevelConfigurationsReader;
import com.tdd.application.gameAbstractions.GameLevel;
import com.tdd.application.gameAbstractions.GameLevelFactory;
import com.tdd.model.exceptions.MalformedXMLException;

public class XMLConductedLevelFactory extends GameLevelFactory {
	
	public XMLConductedLevelFactory(LevelConfigurationsReader givenConfigs) {
		super(givenConfigs);
	}
	
	@Override
	public GameLevel createLevel() throws MalformedXMLException {
		return new XMLConductedLevel(this.configs);
	}

}
