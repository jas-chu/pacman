package com.tdd.application.configuration;

import com.tdd.model.helpers.XMLConstants;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;

public class LevelConfigurations extends LevelConfigurationsReader {
	
	public LevelConfigurations(XMLConstants givenConstants) {
		super(givenConstants);
	}
	
	public LevelConfigurations(XMLConstants givenConstants, Node levelNode) {
		super(givenConstants);
		throw new UnsupportedOperationException("Not supported yet.");
	}
	
	// TO DO
	private void configureProgram() {
		this.setStagePath("");
		this.setCharactersPath("");
		
		this.setPacmanMovementDirectory("");
		
		List<Long> angerWaitingCycles = new ArrayList<Long>();
		angerWaitingCycles.add(new Long(5000));
		angerWaitingCycles.add(new Long(7000));
		angerWaitingCycles.add(new Long(9000));
		this.setGhostAngerWaitingCycles(angerWaitingCycles);
		
		this.setGhostDeadWaitingCycles(500);
		this.setGhostPreyWaitingCycles(350);
		this.setGhostVision(4);
		this.setGhostIncrementalVision(1);
	}
	
	public void setStagePath(String XMLStagePath) {
		this.XMLStagePath = XMLStagePath;
	}

	public void setCharactersPath(String XMLCharactersPath) {
		this.XMLCharactersPath = XMLCharactersPath;
	}

	public void setPacmanMovementDirectory(String XMLPacmanMovementDirectory) {
		this.XMLPacmanMovementDirectory = XMLPacmanMovementDirectory;
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
	
	public void setTicksToRun(int ticksToRun) {
		this.ticksToRun = ticksToRun;
	}
	
}
