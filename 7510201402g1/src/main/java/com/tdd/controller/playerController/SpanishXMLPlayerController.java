package com.tdd.controller.playerController;

import com.tdd.controller.controllerAbstractions.XMLPlayerController;
import com.tdd.model.stage.Pacman;

public class SpanishXMLPlayerController extends XMLPlayerController {

	public SpanishXMLPlayerController(String XMLsDirectoryPath, String givenFilePrefix, Pacman givenPacman) {
		super(XMLsDirectoryPath, givenFilePrefix, givenPacman);
		this.directionTranslator.put(DIRECTION_UP_KEY, "arriba");
		this.directionTranslator.put(DIRECTION_DOWN_KEY, "abajo");
		this.directionTranslator.put(DIRECTION_LEFT_KEY, "izquierda");
		this.directionTranslator.put(DIRECTION_RIGHT_KEY, "derecha");
	}
	
	@Override
	protected String getDirectionNameAttribute() {
		return "direccion";
	}
	
}
