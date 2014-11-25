package com.tdd.application.game;

import com.tdd.application.gameAbstractions.GameLevel;
import com.tdd.application.configuration.LevelConfigurationsReader;
import com.tdd.controller.controllerAbstractions.PlayerController;
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
	public void populateWithProtagonist(Protagonist givenProtagonist, PlayerController givenController) {
		// nope, i won't do that
	}

    /**
     *
     * @return
     */
	@Override
	protected PlayerController createPlayerController() {
		return null;
	}

}
