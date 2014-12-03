package com.tdd.application.game;

import com.tdd.application.gameAbstractions.GameLevel;
import com.tdd.application.configuration.LevelConfigurationsReader;
import com.tdd.model.exceptions.MalformedXMLException;
import com.tdd.model.helpers.XMLConstants;

public class XMLConductedLevel extends GameLevel {
	
    protected String PacmanFilePrefix;

	public XMLConductedLevel(LevelConfigurationsReader givenConfigs) throws MalformedXMLException {
		super(givenConfigs);
        this.PacmanFilePrefix = givenConfigs.getGameConstants().getConstantTranslation(XMLConstants.PACMAN);
	}

}
