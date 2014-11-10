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
		
		fruitHiddenCycles = this.readLongConfiguration(levelNode, XMLConstants.FRUIT_CYCLES);
		fruitPoints = this.readIntConfiguration(levelNode, XMLConstants.FRUIT_POINTS);
		dotPoints = this.readIntConfiguration(levelNode, XMLConstants.DOT_POINTS);
		bigDotPoints = this.readIntConfiguration(levelNode, XMLConstants.BIG_DOT_POINTS);
		enemiesPoints = this.readIntConfiguration(levelNode, XMLConstants.ENEMY_POINTS);
		
		protagonistSpeed = this.readIntConfiguration(levelNode, XMLConstants.PROTAGONIST_SPEED);
		enemiesSpeed = this.readIntConfiguration(levelNode, XMLConstants.ENEMY_SPEED);
		itemsSpeed = this.readIntConfiguration(levelNode, XMLConstants.ITEM_SPEED);
		
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
	
	public void setFruitHiddenCycles(long fruitHiddenCycles) {
		this.fruitHiddenCycles = fruitHiddenCycles;
	}

	public void setFruitPoints(int fruitPoints) {
		this.fruitPoints = fruitPoints;
	}

	public void setDotPoints(int dotPoints) {
		this.dotPoints = dotPoints;
	}

	public void setBigDotPoints(int bigDotPoints) {
		this.bigDotPoints = bigDotPoints;
	}

	public void setEnemiesPoints(int enemiesPoints) {
		this.enemiesPoints = enemiesPoints;
	}

	public void setProtagonistSpeed(int protagonistSpeed) {
		this.protagonistSpeed = protagonistSpeed;
	}

	public void setEnemiesSpeed(int enemiesSpeed) {
		this.enemiesSpeed = enemiesSpeed;
	}

	public void setItemsSpeed(int itemsSpeed) {
		this.itemsSpeed = itemsSpeed;
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
				long value = Long.parseLong(XMLReader.getNodeValue(valueNode));
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
			return 50;
		}
	}
	
}
