package com.tdd.application.main;

import com.tdd.application.gameAbstractions.Game;
import com.tdd.application.gameAbstractions.GameConfigurations;
import com.tdd.model.helpers.XMLConstants;
import com.tdd.model.languageTools.SpanishXMLConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

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
//		configs.XMLStagePaths = completeRootPath + "laberintos" + File.separator + "LaberintoSimple.xml";
//		configs.XMLCharactersPath = completeRootPath + "laberintos" + File.separator + "PersonajesSimple.xml";
//		
//		configs.XMLPacmanMovementDirectory = completeRootPath + XMLConstants.PACMAN;
		
		configs.setSerializationPath(System.getProperty("user.dir")+ File.separator + "ciclosJuego");
		
		List<Long> angerWaitingCycles = new ArrayList<Long>();
		angerWaitingCycles.add(new Long(5000));
		angerWaitingCycles.add(new Long(7000));
		angerWaitingCycles.add(new Long(9000));
		configs.setGhostAngerWaitingCycles(angerWaitingCycles);
		
		configs.setGhostDeadWaitingCycles(500);
		configs.setGhostPreyWaitingCycles(350);
		configs.setGhostVision(4);
		configs.setGhostIncrementalVision(1);
	}
	
	protected String configurePaths(String rootPath) {
		return rootPath + "xmls" + File.separator;
	}
	
	public void run() {
		if (this.game != null) this.game.gameLoop();
	}
	
}
