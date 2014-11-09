package com.tdd.controller.playerController;

import com.tdd.application.configuration.LevelConfigurationsReader;
import com.tdd.controller.controllerAbstractions.PlayerController;
import com.tdd.model.helpers.XMLReader;
import com.tdd.model.directionFactory.DirectionGenerator;
import com.tdd.model.exceptions.NoAvailableFactoryException;
import com.tdd.model.exceptions.NoMoreMovementsException;
import com.tdd.model.helpers.XMLConstants;
import com.tdd.model.stageAbstractions.Direction;
import java.io.File;
import org.w3c.dom.Node;

public class XMLPlayerController implements PlayerController {
	
	private LevelConfigurationsReader configs;
	private DirectionGenerator directionGenerator;
	private Integer currentCycle;
	
	/**
	 *
	 * @param givenConfigs
	 */
	public XMLPlayerController(LevelConfigurationsReader givenConfigs) {
		this.configs = givenConfigs;
		this.directionGenerator = new DirectionGenerator();
		this.currentCycle = 1;
	}
	
	@Override
	public Direction getNewDirection() throws NoMoreMovementsException {
		try {
			String XMLPath = this.getCurrentCycleXML();
			Node gameNode = XMLReader.getFirstNode(XMLPath);
			Node pacmanNode = XMLReader.getNodeByName(XMLPath, XMLConstants.PACMAN).item(0);
			
			String direction = XMLReader.getAttributeValue(pacmanNode, XMLConstants.DIRECTION);
			this.currentCycle++;
			return this.createNewDirection(direction);
		} catch (Exception ex) {
			throw new NoMoreMovementsException();
		}
	}

	private String getCurrentCycleXML() {
		String dir = this.configs.getPacmanMovementDirectory();
		String prefix = this.configs.getGameConstants().getConstantTranslation(XMLConstants.PACMAN);
		prefix += this.configs.getGameConstants().getConstantTranslation(XMLConstants.TICK);
		return dir + File.separator + prefix + this.currentCycle.toString() + ".xml";
	}
	
	private Direction createNewDirection(String direction) throws NoAvailableFactoryException {
		String translatedDirection = this.configs.getGameConstants().getInvertedDirectionValueTranslation(direction);
		return this.directionGenerator.createDirection(translatedDirection);
	}
	
}
