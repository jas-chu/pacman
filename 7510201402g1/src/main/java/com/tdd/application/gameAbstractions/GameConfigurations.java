package com.tdd.application.gameAbstractions;

import com.tdd.model.helpers.XMLConstants;
import java.util.List;

public class GameConfigurations extends GameConfigurationsReader {
	
	public GameConfigurations(XMLConstants givenConstants) {
		super(givenConstants);
	}
	
	public void setSerializationPath(String XMLSerializationPath) {
		this.XMLSerializationPath = XMLSerializationPath;
	}

	public void setGhostAngerWaitingCycles(List<Long> ghostAngerWaitingCycles) {
		this.ghostAngerWaitingCycles = ghostAngerWaitingCycles;
	}

	public void setGhostDeadWaitingCycles(int ghostDeadWaitingCycles) {
		this.ghostDeadWaitingCycles = ghostDeadWaitingCycles;
	}

	public void setGhostPreyWaitingCycles(int ghostPreyWaitingCycles) {
		this.ghostPreyWaitingCycles = ghostPreyWaitingCycles;
	}

	public void setGhostVision(int ghostVision) {
		this.ghostVision = ghostVision;
	}

	public void setGhostIncrementalVision(int ghostIncrementalVision) {
		this.ghostIncrementalVision = ghostIncrementalVision;
	}
	
}
