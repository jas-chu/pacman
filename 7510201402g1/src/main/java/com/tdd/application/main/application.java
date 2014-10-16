package com.tdd.application.main;

import com.tdd.application.game.XMLConductedGame;
import com.tdd.application.gameAbstractions.Game;
import com.tdd.application.gameAbstractions.GameConfigurations;
import com.tdd.model.exceptions.MalformedXMLException;
import com.tdd.model.helpers.XMLConstants;
import com.tdd.model.languageTools.SpanishXMLConstants;
import java.io.File;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class application {
	
	private static void configureProgram(GameConfigurations configs) {
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
	
	public static void main(String[] args) {
		XMLConstants constants = new SpanishXMLConstants();
		GameConfigurations configs = new GameConfigurations(constants);
		configureProgram(configs);
		try {
			Game game = new XMLConductedGame(configs);
			game.gameloop();
		} catch (MalformedXMLException ex) {
			Logger.getLogger(application.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
}
