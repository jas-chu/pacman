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
		this.configureProgram(configs);
	}
	
	private void configureProgram(GameConfigurations configs) {
		String rootPath = System.getProperty("user.dir") + File.separator + "doc";
		rootPath += File.separator + "xmls" + File.separator + "xmls" + File.separator;
		
		configs.XMLStagePath = rootPath + "laberintos" + File.separator + "LaberintoSimple.xml";
		configs.XMLCharactersPath = rootPath + "laberintos" + File.separator + "PersonajesSimple.xml";
		configs.XMLPacmanMovementDirectory = rootPath + XMLConstants.PACMAN;
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
	
	protected abstract void createGame() throws MalformedXMLException;
	
	public void run() {
		if (this.game != null) this.game.gameloop();
	}
	
}
