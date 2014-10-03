package com.tdd.application.game;

import com.tdd.application.gameAbstractions.XMLConductedGame;
import com.tdd.controller.controllerAbstractions.PlayerController;
import com.tdd.controller.playerController.SpanishXMLPlayerController;

public class SpanishXMLConductedGame extends XMLConductedGame {

	public SpanishXMLConductedGame(String XMLStagePath, String givenXMLPacmanDirectory, String givenPacmanFilePrefix) {
		super(XMLStagePath, givenXMLPacmanDirectory, givenPacmanFilePrefix);
	}

	@Override
	protected PlayerController createPlayerController() {
		return new SpanishXMLPlayerController(this.XMLPacmanDirectory, this.PacmanFilePrefix, this.pacman);
	}

}
