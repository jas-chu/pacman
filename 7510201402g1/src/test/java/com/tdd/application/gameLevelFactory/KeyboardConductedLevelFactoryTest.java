package com.tdd.application.gameLevelFactory;

import com.tdd.application.game.KeyboardConductedLevel;
import com.tdd.application.gameAbstractions.GameLevel;
import com.tdd.application.gameAbstractions.GameLevelFactory;
import com.tdd.model.exceptions.MalformedXMLException;

public class KeyboardConductedLevelFactoryTest extends GameLevelFactoryTest {
	
	@Override
	protected int getLevelNumber() {
		return 0;
	}
	
	@Override
	protected GameLevelFactory createParameterlessFactory() {
		return new KeyboardConductedLevelFactory();
	}

	@Override
	protected GameLevel createLevelExample() throws MalformedXMLException {
		return new KeyboardConductedLevel(this.configs);
	}

}