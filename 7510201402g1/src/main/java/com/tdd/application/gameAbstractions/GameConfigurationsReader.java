package com.tdd.application.gameAbstractions;

import com.tdd.model.helpers.XMLConstants;
import com.tdd.model.helpers.XMLIO;
import java.util.ArrayList;
import java.util.List;

public abstract class GameConfigurationsReader {
	
	protected XMLConstants XMLGameConstants;
	
	// PATHS
	protected String XMLSerializationPath = "";
	
	// GAME PARAMETERS
	protected List<Long> ghostAngerWaitingCycles = new ArrayList<Long>();
	protected int ghostDeadWaitingCycles = 1;
	protected int ghostPreyWaitingCycles = 1;
	protected int ghostVision = 1;
    protected int ghostIncrementalVision = 1;
	
	public GameConfigurationsReader(XMLConstants givenConstants) {
		this.XMLGameConstants = givenConstants;
		XMLIO.configureLanguage(this.XMLGameConstants);
	}

	public XMLConstants getGameConstants() {
		return XMLGameConstants;
	}

	public String getSerializationPath() {
		return XMLSerializationPath;
	}

	public List<Long> getGhostAngerWaitingCycles() {
		return ghostAngerWaitingCycles;
	}

	public int getGhostDeadWaitingCycles() {
		return ghostDeadWaitingCycles;
	}

	public int getGhostPreyWaitingCycles() {
		return ghostPreyWaitingCycles;
	}

	public int getGhostVision() {
		return ghostVision;
	}

	public int getGhostIncrementalVision() {
		return ghostIncrementalVision;
	}
	
}
