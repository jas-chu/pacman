package com.tdd.application.gameLevelFactory;

import com.tdd.application.game.XMLConductedLevel;
import com.tdd.application.gameAbstractions.GameConfigurations;
import com.tdd.application.gameAbstractions.GameLevel;
import com.tdd.application.gameAbstractions.GameLevelFactory;
import com.tdd.model.exceptions.MalformedXMLException;

public class XMLConductedLevelFactory extends GameLevelFactory {
	
	private String XMLPacmanDirectory;
	
	public XMLConductedLevelFactory(GameConfigurations givenConfigs, String givenXMLStagePath,
								String givenXMLCharactersPath, String XMLPacmanMovementDirectory) {
		super(givenConfigs, givenXMLStagePath, givenXMLCharactersPath);
		this.XMLPacmanDirectory = XMLPacmanMovementDirectory;
	}
	
	@Override
	public GameLevel createLevel() throws MalformedXMLException {
		return new XMLConductedLevel(this.configs, this.XMLStagePath, this.XMLCharactersPath, this.XMLPacmanDirectory);
	}

}
