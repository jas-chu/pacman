package com.tdd.application.gameLevelFactory;

import com.tdd.application.game.NoPacmanLevel;
import com.tdd.application.gameAbstractions.GameConfigurations;
import com.tdd.application.gameAbstractions.GameLevel;
import com.tdd.application.gameAbstractions.GameLevelFactory;
import com.tdd.model.exceptions.MalformedXMLException;

public class NoPacmanLevelFactory extends GameLevelFactory {
	
	protected long ticksToRun;
	
	public NoPacmanLevelFactory(GameConfigurations givenConfigs, String givenXMLStagePath,
								String givenXMLCharactersPath, long givenTicksToRun) {
		super(givenConfigs, givenXMLStagePath, givenXMLCharactersPath);
		this.ticksToRun = givenTicksToRun;
	}
	
	@Override
	public GameLevel createLevel() throws MalformedXMLException {
		return new NoPacmanLevel(this.configs, this.XMLStagePath, this.XMLCharactersPath, this.ticksToRun);
	}

}
