package com.tdd.application.game;

import com.tdd.application.gameAbstractions.GameLevel;
import com.tdd.application.configuration.LevelConfigurationsReader;
import com.tdd.controller.controllerAbstractions.PlayerController;
import com.tdd.controller.playerController.KeyboardPlayerController;
import com.tdd.model.exceptions.MalformedXMLException;

public class KeyboardConductedLevel extends GameLevel {

    public KeyboardConductedLevel(LevelConfigurationsReader givenConfigs) throws MalformedXMLException {
		super(givenConfigs);
	}

    @Override
    protected PlayerController createPlayerController() {
        return new KeyboardPlayerController();
    }

}
