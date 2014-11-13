package com.tdd.application.game;

import com.tdd.application.gameAbstractions.GameLevel;
import com.tdd.application.configuration.LevelConfigurationsReader;
import com.tdd.controller.controllerAbstractions.PlayerController;
import com.tdd.controller.playerController.KeyboardPlayerController;
import com.tdd.model.exceptions.MalformedXMLException;
import com.tdd.model.stageAbstractions.Protagonist;

public class NoPacmanLevel extends GameLevel {
	
	private long ticksToRun;
	
	public NoPacmanLevel(LevelConfigurationsReader givenConfigs, long givenTicksToRun)
						throws MalformedXMLException {
		
		super(givenConfigs);
		this.ticksToRun = givenTicksToRun;
	}
	
	@Override
	public boolean isEndOfLevel() {
		return (this.ticksToRun == this.ticks);
	}
	
	@Override
	public void populateWithProtagonist(Protagonist givenProtagonist) {
		// nope, i won't do that
	}

    /**
     *
     * @return
     */
	protected PlayerController createPlayerController() {
		return null;
	}

    @Override
    protected KeyboardPlayerController createPlayerController() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
