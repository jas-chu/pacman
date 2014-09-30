package com.tdd.application;

import com.tdd.helpers.XMLReader;
import com.tdd.model.direction.*;
import com.tdd.model.stage.Pacman;
import com.tdd.model.stageAbstractions.Direction;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.w3c.dom.Node;

public class PlayerController {
	
	private Pacman pacman;
	private String XMLDirectory;
	private Integer currentCycle;
	
	public PlayerController(String XMLsDirectoryPath, Pacman givenPacman) {
		this.XMLDirectory = XMLsDirectoryPath;
		this.currentCycle = 1;
		this.pacman = givenPacman;
	}

	public void processMovement() {
		Direction dir = this.getNextDirection();
		this.pacman.move(dir);
		this.advanceCycle();
	}
	
	private void advanceCycle() {
		this.currentCycle++;
	}
	
	private Direction getNextDirection() {
		try {
			String XMLPath = this.getCurrentCycleXML();
			Node gameNode = XMLReader.getFirstNode(XMLPath);
			Node pacmanNode = gameNode.getFirstChild();
			String direction = XMLReader.getAttributeValue(pacmanNode, "direccion");
			return this.createNewDirection(direction);
		} catch (Exception ex) {
			Logger.getLogger(PlayerController.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}

	private String getCurrentCycleXML() {
		String filePath = this.XMLDirectory + File.separator + "pacmanTick" + this.currentCycle.toString() + ".xml";
		return filePath;
	}

	private Direction createNewDirection(String direction) {
		if (direction.equals("arriba"))
			return new DirectionUp();
		if (direction.equals("abajo"))
			return new DirectionDown();
		if (direction.equals("izquierda"))
			return new DirectionLeft();
		return new DirectionRight();
	}
	
}
