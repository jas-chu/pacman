package com.tdd.application.game;

import com.tdd.application.gameAbstractions.GameLevel;
import com.tdd.application.gameAbstractions.GameConfigurations;
import com.tdd.controller.controllerAbstractions.PlayerController;
import com.tdd.controller.playerController.KeyboardPlayerController;
import com.tdd.model.exceptions.MalformedXMLException;

public class KeyboardConductedLevel extends GameLevel {

    public KeyboardConductedLevel(GameConfigurations givenConfigs, String XMLStagePath,
							String XMLCharactersPath) throws MalformedXMLException {
		
		super(givenConfigs, XMLStagePath, XMLCharactersPath);
	}

    @Override
    protected PlayerController createPlayerController() {
        return new KeyboardPlayerController();
    }

}
