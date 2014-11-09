package com.tdd.application.gameAbstractions;

import com.tdd.application.configuration.LevelConfigurationsReader;
import com.tdd.model.exceptions.MalformedXMLException;
import com.tdd.model.exceptions.NotMyJobException;

public abstract class GameLevelFactory {
	
	protected LevelConfigurationsReader configs;
	
	public GameLevelFactory() {
		super();
	}
	
	protected GameLevelFactory(LevelConfigurationsReader givenConfigs) {
		this.configs = givenConfigs;
	}
	
	protected abstract String getMyLevelType();
	
	/**
	 * Tests if the levelType corresponds to the specific factory.
	 * @param levelType
	 * @throws NotMyJobException
	 */
	public void testCreateFactory(String levelType) throws NotMyJobException {
		if (!(this.getMyLevelType()).equals(levelType)) throw new NotMyJobException();
	}
	
	/**
	 * Creates a new factory of its own class. Serves as a factory method for itself.
	 * @param givenConfigs 
	 * @return a GameLevelFactory
	 */
	public abstract GameLevelFactory createFactory(LevelConfigurationsReader givenConfigs);
	
	/**
	 * Creates a new specific level. Serves as a factory method for the different available levels.
	 * @return a GameLevel
	 * @throws MalformedXMLException
	 */
	public abstract GameLevel createLevel() throws MalformedXMLException;

}
