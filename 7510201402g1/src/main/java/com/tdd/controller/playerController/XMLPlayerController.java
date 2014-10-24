package com.tdd.controller.playerController;

import com.tdd.application.gameAbstractions.GameConfigurations;
import com.tdd.controller.controllerAbstractions.PlayerController;
import com.tdd.model.helpers.XMLReader;
import com.tdd.model.directionFactory.DirectionGenerator;
import com.tdd.model.exceptions.NoAvailableFactoryException;
import com.tdd.model.exceptions.NoMoreMovementsException;
import com.tdd.model.helpers.XMLConstants;
import com.tdd.model.stageAbstractions.Direction;
import com.tdd.model.stageAbstractions.Protagonist;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.AttributeNotFoundException;
import org.w3c.dom.Node;

public class XMLPlayerController extends PlayerController {
	
	private GameConfigurations configs;
	private DirectionGenerator directionGenerator;
	
	/**
	 *
	 * @param givenConfigs
	 * @param givenProtagonist
	 */
	public XMLPlayerController(GameConfigurations givenConfigs, Protagonist givenProtagonist) {
		super(givenProtagonist);
		this.configs = givenConfigs;
		this.directionGenerator = new DirectionGenerator();
	}
	
	@Override
	protected Direction getNextDirection() throws NoMoreMovementsException {
		try {
			String XMLPath = this.getCurrentCycleXML();
			Node gameNode = XMLReader.getFirstNode(XMLPath);
			Node pacmanNode = XMLReader.getNodeByName(XMLPath, XMLConstants.PACMAN).item(0);
			
			String direction = XMLReader.getAttributeValue(pacmanNode, XMLConstants.DIRECTION);
			return this.createNewDirection(direction);
		} catch (Exception ex) {
			throw new NoMoreMovementsException();
		}
	}

	private String getCurrentCycleXML() {
		String dir = this.configs.XMLPacmanMovementDirectory;
		String prefix = this.configs.XMLGameConstants.getConstantTranslation(XMLConstants.PACMAN);
		prefix += this.configs.XMLGameConstants.getConstantTranslation(XMLConstants.TICK);
		return dir + File.separator + prefix + this.currentCycle.toString() + ".xml";
	}
	
	private Direction createNewDirection(String direction) throws NoAvailableFactoryException {
		String translatedDirection = this.configs.XMLGameConstants.getInvertedDirectionValueTranslation(direction);
		return this.directionGenerator.createDirection(translatedDirection);
	}
	
}
