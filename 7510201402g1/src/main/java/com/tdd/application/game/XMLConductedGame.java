package com.tdd.application.game;

import com.tdd.application.gameAbstractions.Game;
import com.tdd.controller.controllerAbstractions.PlayerController;
import com.tdd.controller.playerController.XMLPlayerController;
import com.tdd.model.helpers.XMLConstants;
import javax.management.AttributeNotFoundException;

public class XMLConductedGame extends Game {
	
	protected String XMLPacmanDirectory;
	protected String PacmanFilePrefix;
	
	public XMLConductedGame(String XMLStagePath, XMLConstants XMLGameConstants,
							String givenXMLPacmanDirectory, String givenPacmanFilePrefix)
							throws AttributeNotFoundException {
		super(XMLStagePath, XMLGameConstants);
		this.XMLPacmanDirectory = givenXMLPacmanDirectory;
		this.PacmanFilePrefix = givenPacmanFilePrefix;
	}
	
	@Override
	protected PlayerController createPlayerController() {
		return new XMLPlayerController(this.XMLPacmanDirectory, this.PacmanFilePrefix, this.protagonist, this.gameConstants);
	}
	
}
