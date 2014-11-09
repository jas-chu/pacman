package com.tdd.application.configuration;

import com.tdd.model.exceptions.NoNodeWithThatNameException;
import com.tdd.model.helpers.XMLConstants;
import com.tdd.model.helpers.XMLReader;
import java.util.ArrayList;
import java.util.List;
import org.w3c.dom.Node;

public class LevelConfigurations extends LevelConfigurationsReader {
	
	public LevelConfigurations(XMLConstants givenConstants) {
		super(givenConstants);
	}
	
	/**
	 * Construction from XML node
	 * @param givenConstants
	 * @param levelNode
	 */
	public LevelConfigurations(XMLConstants givenConstants, Node levelNode) {
		super(givenConstants);
		
		XMLStagePath = this.readStringConfiguration(levelNode, XMLConstants.STAGE);
		XMLCharactersPath = this.readStringConfiguration(levelNode, XMLConstants.CHARACTERS);
		XMLPacmanMovementDirectory = this.readStringConfiguration(levelNode, XMLConstants.PACMAN);
		XMLSerializationPath = this.readStringConfiguration(levelNode, XMLConstants.SAVE_PATH);
		
		ghostAngerWaitingCycles = this.readAngerCyclesConfiguration(levelNode, XMLConstants.ANGER_CYCLES);
		ghostDeadWaitingCycles = this.readIntConfiguration(levelNode, XMLConstants.DEAD_CYCLES);
		ghostPreyWaitingCycles = this.readIntConfiguration(levelNode, XMLConstants.PREY_CYCLES);
		ghostVision = this.readIntConfiguration(levelNode, XMLConstants.GHOST_VISION);
		ghostIncrementalVision = this.readIntConfiguration(levelNode, XMLConstants.INCREMENTAL_VISION);
		
		ticksToRun = this.readLongConfiguration(levelNode, XMLConstants.TICKS_TO_RUN);
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
	
	private List<Long> readAngerCyclesConfiguration(Node levelNode, String tagName) {
		List<Long> angerCycles = new ArrayList<Long>();
		try {
			Node angerCyclesNode = XMLReader.getFirstNodeWithName(levelNode, tagName);
			List<Node> valueNodes = XMLReader.getNodeByName(angerCyclesNode, XMLConstants.VALUE);
			for (Node valueNode : valueNodes) {
				long value = Long.parseLong(valueNode.getNodeValue());
				angerCycles.add(value);
			}
		} catch (NoNodeWithThatNameException ex) { }
		return angerCycles;
	}
	
	
	private String readStringConfiguration(Node levelNode, String tagName) {
		try {
			return XMLReader.getFirstNodeValueWithName(levelNode, tagName);
		} catch (NoNodeWithThatNameException ex) {
			return "";
		}
	}
	
	private int readIntConfiguration(Node levelNode, String tagName) {
		try {
			return XMLReader.getFirstNodeIntValueWithName(levelNode, tagName);
		} catch (NoNodeWithThatNameException ex) {
			return 1;
		}
	}
	
	private long readLongConfiguration(Node levelNode, String tagName) {
		try {
			return XMLReader.getFirstNodeLongValueWithName(levelNode, tagName);
		} catch (NoNodeWithThatNameException ex) {
			return 10;
		}
	}
	
}
