package com.tdd.application.main;

import com.tdd.application.game.NoEnemiesGame;
import com.tdd.model.exceptions.MalformedXMLException;
import java.io.File;

public class NoEnemiesApplication extends Application {
	
	@Override
	protected void createGame() throws MalformedXMLException {
		this.game = new NoEnemiesGame(this.configs);
	}
	
	@Override
	protected String configurePaths(String rootPath) {
		return rootPath + "test_sin_fantasma" + File.separator;
	}

}
