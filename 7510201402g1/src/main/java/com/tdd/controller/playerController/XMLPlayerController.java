package com.tdd.controller.playerController;

import com.tdd.controller.controllerAbstractions.PlayerController;
import com.tdd.model.helpers.XMLReader;
import com.tdd.model.directionFactory.DirectionGenerator;
import com.tdd.model.helpers.XMLConstants;
import com.tdd.model.stageAbstractions.Direction;
import com.tdd.model.stageAbstractions.Protagonist;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.w3c.dom.Node;

public class XMLPlayerController extends PlayerController {
	
	private String XMLDirectory;
	private String filePrefix;
	private XMLConstants constants;
	private DirectionGenerator directionGenerator;
	
	/**
	 *
	 * @param XMLsDirectoryPath
	 * @param givenFilePrefix: por ejemplo, "pacmanTick"
	 * @param givenProtagonist
	 */
	public XMLPlayerController(String XMLsDirectoryPath, String givenFilePrefix,
							   Protagonist givenProtagonist, XMLConstants XMLGameConstants) {
		super(givenProtagonist);
		this.XMLDirectory = XMLsDirectoryPath;
		this.filePrefix = givenFilePrefix;
		this.constants = XMLGameConstants;
		this.directionGenerator = new DirectionGenerator();
	}
	
	@Override
	protected Direction getNextDirection() {
		try {
			String XMLPath = this.getCurrentCycleXML();
			Node gameNode = XMLReader.getFirstNode(XMLPath);
			Node pacmanNode = gameNode.getFirstChild();
			String direction = XMLReader.getAttributeValue(pacmanNode, XMLConstants.DIRECTION);
			return this.createNewDirection(direction);
		} catch (Exception ex) {
			Logger.getLogger(XMLPlayerController.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	private String getCurrentCycleXML() {
		String filePath = this.XMLDirectory + File.separator + this.filePrefix + this.currentCycle.toString() + ".xml";
		return filePath;
	}
	
	private Direction createNewDirection(String direction) {
		String translatedDirection = this.constants.getDirectionValueTranslation(direction);
		return this.directionGenerator.createDirection(translatedDirection);
	}
	
}
