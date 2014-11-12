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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
