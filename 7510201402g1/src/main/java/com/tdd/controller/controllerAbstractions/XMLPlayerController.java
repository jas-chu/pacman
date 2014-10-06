package com.tdd.controller.controllerAbstractions;

import com.tdd.model.helpers.XMLReader;
import com.tdd.model.direction.DirectionDown;
import com.tdd.model.direction.DirectionLeft;
import com.tdd.model.direction.DirectionRight;
import com.tdd.model.direction.DirectionUp;
import com.tdd.model.stageAbstractions.Direction;
import com.tdd.model.stageAbstractions.Protagonist;
import java.io.File;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.w3c.dom.Node;

public abstract class XMLPlayerController extends PlayerController {
	
	private String XMLDirectory;
	private String filePrefix;
	
	protected static String DIRECTION_UP_KEY = "up";
	protected static String DIRECTION_DOWN_KEY = "down";
	protected static String DIRECTION_LEFT_KEY = "left";
	protected static String DIRECTION_RIGHT_KEY = "right";
	protected Map<String,String> directionTranslator;
	
	/**
	 *
	 * @param XMLsDirectoryPath
	 * @param givenFilePrefix: por ejemplo, "pacmanTick"
	 * @param givenProtagonist
	 */
	public XMLPlayerController(String XMLsDirectoryPath, String givenFilePrefix, Protagonist givenProtagonist) {
		super(givenProtagonist);
		this.XMLDirectory = XMLsDirectoryPath;
		this.filePrefix = givenFilePrefix;
		this.directionTranslator = new HashMap<String,String>();
	}
	
	@Override
	protected Direction getNextDirection() {
		try {
			String XMLPath = this.getCurrentCycleXML();
			Node gameNode = XMLReader.getFirstNode(XMLPath);
			Node pacmanNode = gameNode.getFirstChild();
			String direction = XMLReader.getAttributeValue(pacmanNode, this.getDirectionNameAttribute());
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
	
	protected abstract String getDirectionNameAttribute();
	
	protected Direction createNewDirection(String direction) {
		try{
			if (direction.equals(this.directionTranslator.get(DIRECTION_UP_KEY)))
				return new DirectionUp();
			if (direction.equals(this.directionTranslator.get(DIRECTION_DOWN_KEY)))
				return new DirectionDown();
			if (direction.equals(this.directionTranslator.get(DIRECTION_LEFT_KEY)))
				return new DirectionLeft();
		} catch (Exception ex) {
			Logger.getLogger(XMLPlayerController.class.getName()).log(Level.SEVERE, null, ex);
		}
		return new DirectionRight();
	}
	
}
