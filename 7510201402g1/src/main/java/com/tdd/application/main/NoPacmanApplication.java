package com.tdd.application.main;

import com.tdd.application.game.NoPacmanGame;
import com.tdd.model.exceptions.MalformedXMLException;
import java.io.File;

public class NoPacmanApplication extends Application {
	
	private long ticks;
	
	public NoPacmanApplication(long givenTicks) {
		this.ticks = givenTicks;
	}
	
	@Override
	protected void createGame() throws MalformedXMLException {
		this.game = new NoPacmanGame(this.configs, this.ticks);
	}
	
	@Override
	protected String configurePaths(String rootPath) {
		return rootPath + "test_sin_pacman" + File.separator;
	}

}
