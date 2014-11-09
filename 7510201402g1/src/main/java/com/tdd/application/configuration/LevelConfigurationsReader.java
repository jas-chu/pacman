package com.tdd.application.configuration;

import com.tdd.model.helpers.XMLConstants;
import java.util.ArrayList;
import java.util.List;

public abstract class LevelConfigurationsReader {
	
	protected final XMLConstants XMLGameConstants;
	
	// LEVEL PATHS
	protected String XMLStagePath = "";
	protected String XMLCharactersPath = "";
	protected String XMLPacmanMovementDirectory = "";
	protected String XMLSerializationPath = "";
	
	// LEVEL PARAMETERS
	protected List<Long> ghostAngerWaitingCycles = new ArrayList<Long>();
	protected int ghostDeadWaitingCycles = 1;
	protected int ghostPreyWaitingCycles = 1;
	protected int ghostVision = 1;
    protected int ghostIncrementalVision = 1;
	protected long ticksToRun = 10;
	
	public LevelConfigurationsReader(XMLConstants givenConstants) {
		this.XMLGameConstants = givenConstants;
	}

	public XMLConstants getGameConstants() {
		return XMLGameConstants;
	}
	
	public String getStagePath() {
		return XMLStagePath;
	}

	public String getCharactersPath() {
		return XMLCharactersPath;
	}

	public String getPacmanMovementDirectory() {
		return XMLPacmanMovementDirectory;
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

	public long getTicksToRun() {
		return ticksToRun;
	}
	
}
