package com.tdd.application.gameLevelFactory;

import com.tdd.application.game.NoPacmanLevel;
import com.tdd.application.gameAbstractions.GameLevel;
import com.tdd.application.gameAbstractions.GameLevelFactory;
import com.tdd.model.exceptions.MalformedXMLException;

public class NoPacmanLevelFactoryTest extends GameLevelFactoryTest {
	
	@Override
	protected int getLevelNumber() {
		return 1;
	}
	
	@Override
	protected GameLevelFactory createParameterlessFactory() {
		return new NoPacmanLevelFactory();
	}

	@Override
	protected GameLevel createLevelExample() throws MalformedXMLException {
		return new NoPacmanLevel(this.configs, 10);
	}

}