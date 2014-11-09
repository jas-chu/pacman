package com.tdd.application.gameLevelFactory;

import com.tdd.application.game.NoPacmanLevel;
import com.tdd.application.configuration.LevelConfigurationsReader;
import com.tdd.application.gameAbstractions.GameLevel;
import com.tdd.application.gameAbstractions.GameLevelFactory;
import com.tdd.model.exceptions.MalformedXMLException;

public class NoPacmanLevelFactory extends GameLevelFactory {
	
	protected long ticksToRun;
	
	public NoPacmanLevelFactory(LevelConfigurationsReader givenConfigs, long givenTicksToRun) {
		super(givenConfigs);
		this.ticksToRun = givenTicksToRun;
	}
	
	@Override
	public GameLevel createLevel() throws MalformedXMLException {
		return new NoPacmanLevel(this.configs, this.ticksToRun);
	}

}
