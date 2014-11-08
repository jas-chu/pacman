package com.tdd.application.game;

import com.tdd.application.gameAbstractions.GameLevel;
import com.tdd.application.gameAbstractions.GameConfigurations;
import com.tdd.controller.controllerAbstractions.PlayerController;
import com.tdd.controller.playerController.XMLPlayerController;
import com.tdd.model.exceptions.MalformedXMLException;
import com.tdd.model.helpers.XMLConstants;

public class XMLConductedLevel extends GameLevel {

    protected String XMLPacmanDirectory;
    protected String PacmanFilePrefix;

	public XMLConductedLevel(GameConfigurations givenConfigs, String XMLStagePath,
							String XMLCharactersPath, String XMLPacmanMovementDirectory)
							throws MalformedXMLException {
		
		super(givenConfigs, XMLStagePath, XMLCharactersPath);
		this.XMLPacmanDirectory = XMLPacmanMovementDirectory;
        this.PacmanFilePrefix = givenConfigs.XMLGameConstants.getConstantTranslation(XMLConstants.PACMAN);
	}

    @Override
    protected PlayerController createPlayerController() {
        return new XMLPlayerController(this.configs, this.XMLPacmanDirectory);
    }

}
