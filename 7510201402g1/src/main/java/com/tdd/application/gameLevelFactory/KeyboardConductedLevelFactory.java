package com.tdd.application.gameLevelFactory;

import com.tdd.application.game.KeyboardConductedLevel;
import com.tdd.application.gameAbstractions.GameConfigurations;
import com.tdd.application.gameAbstractions.GameLevel;
import com.tdd.application.gameAbstractions.GameLevelFactory;
import com.tdd.model.exceptions.MalformedXMLException;

public class KeyboardConductedLevelFactory extends GameLevelFactory {
	
	public KeyboardConductedLevelFactory(GameConfigurations givenConfigs, String givenXMLStagePath,
								String givenXMLCharactersPath) {
		super(givenConfigs, givenXMLStagePath, givenXMLCharactersPath);
	}
	
	@Override
	public GameLevel createLevel() throws MalformedXMLException {
		return new KeyboardConductedLevel(this.configs, this.XMLStagePath, this.XMLCharactersPath);
	}

}
