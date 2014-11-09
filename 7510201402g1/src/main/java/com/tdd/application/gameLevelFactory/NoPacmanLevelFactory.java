package com.tdd.application.gameLevelFactory;

import com.tdd.application.game.NoPacmanLevel;
import com.tdd.application.configuration.LevelConfigurationsReader;
import com.tdd.application.gameAbstractions.GameLevel;
import com.tdd.application.gameAbstractions.GameLevelFactory;
import com.tdd.model.exceptions.MalformedXMLException;
import com.tdd.model.helpers.XMLConstants;

public class NoPacmanLevelFactory extends GameLevelFactory {
	
	protected long ticksToRun;
	
	public NoPacmanLevelFactory() {
		super();
	}
	
	private NoPacmanLevelFactory(LevelConfigurationsReader givenConfigs) {
		super(givenConfigs);
		this.ticksToRun = givenConfigs.getTicksToRun();
	}
	
	@Override
	protected String getMyLevelType() {
		return XMLConstants.NO_PACMAN_LEVEL;
	}
	
	@Override
	public GameLevelFactory createFactory(LevelConfigurationsReader givenConfigs) {
		return new NoPacmanLevelFactory(givenConfigs);
	}
	
	@Override
	public GameLevel createLevel() throws MalformedXMLException {
		return new NoPacmanLevel(this.configs, this.ticksToRun);
	}

}
