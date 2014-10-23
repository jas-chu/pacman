package com.tdd.application.main;

import com.tdd.application.game.XMLConductedGame;
import com.tdd.model.exceptions.MalformedXMLException;
import java.io.File;

public class NormalApplication extends Application {
	
	@Override
	protected void createGame() throws MalformedXMLException {
		this.game = new XMLConductedGame(this.configs);
	}
	
	@Override
	protected String configurePaths(String rootPath) {
		return rootPath + "test_fantasma_pacman" + File.separator;
	}

}
