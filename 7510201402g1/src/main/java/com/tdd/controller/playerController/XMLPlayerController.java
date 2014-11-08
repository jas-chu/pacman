package com.tdd.controller.playerController;

import com.tdd.application.gameAbstractions.GameConfigurations;
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
	
	private GameConfigurations configs;
	private String XMLPacmanDirectory;
	private DirectionGenerator directionGenerator;
	private Integer currentCycle;
	
	/**
	 *
	 * @param givenConfigs
	 */
	public XMLPlayerController(GameConfigurations givenConfigs, String XMLPacmanMovementDirectory) {
		this.configs = givenConfigs;
		this.XMLPacmanDirectory = XMLPacmanMovementDirectory;
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
		String dir = this.XMLPacmanDirectory;
		String prefix = this.configs.XMLGameConstants.getConstantTranslation(XMLConstants.PACMAN);
		prefix += this.configs.XMLGameConstants.getConstantTranslation(XMLConstants.TICK);
		return dir + File.separator + prefix + this.currentCycle.toString() + ".xml";
	}
	
	private Direction createNewDirection(String direction) throws NoAvailableFactoryException {
		String translatedDirection = this.configs.XMLGameConstants.getInvertedDirectionValueTranslation(direction);
		return this.directionGenerator.createDirection(translatedDirection);
	}
	
}
