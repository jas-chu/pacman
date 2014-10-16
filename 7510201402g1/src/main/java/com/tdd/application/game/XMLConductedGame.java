package com.tdd.application.game;

import com.tdd.application.gameAbstractions.Game;
import com.tdd.controller.controllerAbstractions.PlayerController;
import com.tdd.controller.playerController.XMLPlayerController;
import com.tdd.model.exceptions.MalformedXMLException;
import com.tdd.model.helpers.XMLConstants;

public class XMLConductedGame extends Game {

    protected String XMLPacmanDirectory;
    protected String PacmanFilePrefix;
	
	public XMLConductedGame(String XMLStagePath, String XMLCharactersPath, String XMLSerializationPath,
							XMLConstants XMLGameConstants, String givenXMLPacmanDirectory)
							throws MalformedXMLException {
		
        super(XMLStagePath, XMLCharactersPath, XMLSerializationPath, XMLGameConstants);
        this.XMLPacmanDirectory = givenXMLPacmanDirectory;
        this.PacmanFilePrefix = XMLGameConstants.getConstantTranslation(XMLConstants.PACMAN);
    }

    @Override
    protected PlayerController createPlayerController() {
        return new XMLPlayerController(this.XMLPacmanDirectory, this.PacmanFilePrefix, this.protagonist, this.gameConstants);
    }

}
