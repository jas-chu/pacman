package com.tdd.application.gameLevelFactory;

import com.tdd.application.configuration.LevelConfigurations;
import com.tdd.application.gameAbstractions.GameLevel;
import com.tdd.application.gameAbstractions.GameLevelFactory;
import com.tdd.model.exceptions.MalformedXMLException;
import com.tdd.model.exceptions.NoLevelConfigurationsException;
import com.tdd.tests.helpers.TestsHelper;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public abstract class GameLevelFactoryTest {

    GameLevelFactory ParameterlessFactory;
	GameLevel levelExample;
	LevelConfigurations configs;
	
	@Before
	public void setUp() {
		this.configs = TestsHelper.createLevelConfigurations(this.getLevelNumber());
		try {
			this.levelExample = this.createLevelExample();
		} catch (MalformedXMLException ex) {
			fail();
		}
		this.ParameterlessFactory = this.createParameterlessFactory();
	}
	
	protected abstract int getLevelNumber();
	protected abstract GameLevelFactory createParameterlessFactory();
	protected abstract GameLevel createLevelExample() throws MalformedXMLException;
	
	@Test
    public void ParameterlessCreationTest() {
        assert(this.createParameterlessFactory() != null);
    }
	
	@Test
    public void CloneTest() {
        assert(this.ParameterlessFactory.createFactory(this.configs) != null);
    }

    @Test
    public void createLevelNoConfigsTest() {
		try {
			this.ParameterlessFactory.createLevel();
			fail();
		} catch (NoLevelConfigurationsException ex) {
			assert(true);
		} catch (MalformedXMLException ex) {
			fail();
		}
    }
	
	@Test
    public void createLevelWithConfigsTest() {
		GameLevelFactory factory = this.ParameterlessFactory.createFactory(this.configs);
		try {
			GameLevel level = factory.createLevel();
			assert(level != null);
			assert(level.getClass().equals(this.levelExample.getClass()));
		} catch (NoLevelConfigurationsException | MalformedXMLException ex) {
			fail();
		}
    }

}