package com.tdd.application.game;

import com.tdd.application.gameAbstractions.GameLevel;
import com.tdd.application.configuration.LevelConfigurationsReader;
import com.tdd.model.exceptions.MalformedXMLException;

public class KeyboardConductedLevel extends GameLevel {

    public KeyboardConductedLevel(LevelConfigurationsReader givenConfigs) throws MalformedXMLException {
        super(givenConfigs);
    }

}
