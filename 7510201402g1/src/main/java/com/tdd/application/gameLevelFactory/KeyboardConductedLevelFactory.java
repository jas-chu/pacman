package com.tdd.application.gameLevelFactory;

import com.tdd.application.game.KeyboardConductedLevel;
import com.tdd.application.configuration.LevelConfigurationsReader;
import com.tdd.application.gameAbstractions.GameLevel;
import com.tdd.application.gameAbstractions.GameLevelFactory;
import com.tdd.model.exceptions.MalformedXMLException;

public class KeyboardConductedLevelFactory extends GameLevelFactory {

    public KeyboardConductedLevelFactory() {
        super();
    }

    private KeyboardConductedLevelFactory(LevelConfigurationsReader givenConfigs) {
        super(givenConfigs);
    }

    @Override
    public GameLevelFactory createFactory(LevelConfigurationsReader givenConfigs) {
        return new KeyboardConductedLevelFactory(givenConfigs);
    }

    @Override
    public GameLevel createLevel() throws MalformedXMLException {
        return new KeyboardConductedLevel(this.configs);
    }

}
