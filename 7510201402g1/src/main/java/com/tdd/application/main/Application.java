package com.tdd.application.main;

import com.tdd.application.gameAbstractions.Game;
import com.tdd.application.gameAbstractions.GameConfigurations;
import com.tdd.model.exceptions.MalformedXMLException;
import com.tdd.model.helpers.XMLConstants;
import com.tdd.model.languageTools.SpanishXMLConstants;
import java.io.File;
import java.util.ArrayList;

public abstract class Application {
	
	protected XMLConstants constants;
	protected GameConfigurations configs;
	protected Game game = null;
	
	public Application() {
		this.constants = new SpanishXMLConstants();
		this.configs = new GameConfigurations(constants);
		this.configureProgram();
	}
	
	private void configureProgram() {
		String rootPath = System.getProperty("user.dir") + File.separator + "doc";
		rootPath += File.separator + "xmls" + File.separator;
		String completeRootPath = this.configurePaths(rootPath);
		configs.XMLStagePath = completeRootPath + "laberintos" + File.separator + "LaberintoSimple.xml";
		configs.XMLCharactersPath = completeRootPath + "laberintos" + File.separator + "PersonajesSimple.xml";
		configs.XMLPacmanMovementDirectory = completeRootPath + XMLConstants.PACMAN;
		configs.XMLSerializationPath = System.getProperty("user.dir")+ File.separator + "ciclosJuego";
		
		configs.ghostAngerWaitingCycles = new ArrayList<Long>();
		configs.ghostAngerWaitingCycles.add(new Long(5000));
		configs.ghostAngerWaitingCycles.add(new Long(7000));
		configs.ghostAngerWaitingCycles.add(new Long(9000));
		
		configs.ghostDeadWaitingCycles = 500;
		configs.ghostPreyWaitingCycles = 350;
		configs.ghostVision = 4;
		configs.ghostIncrementalVision = 1;
	}
	
	protected String configurePaths(String rootPath) {
		return rootPath + "xmls" + File.separator;
	}
	
	protected abstract void createGame() throws MalformedXMLException;
	
	public void run() {
		if (this.game != null) this.game.gameloop();
	}
	
}
