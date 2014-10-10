package com.tdd.controller.playerController;

import com.tdd.controller.controllerAbstractions.XMLPlayerController;
import com.tdd.model.directionFactory.DirectionGenerator;
import com.tdd.model.stageAbstractions.Protagonist;

public class SpanishXMLPlayerController extends XMLPlayerController {

	public SpanishXMLPlayerController(String XMLsDirectoryPath, String givenFilePrefix, Protagonist givenProtagonist) {
		super(XMLsDirectoryPath, givenFilePrefix, givenProtagonist);
		this.directionTranslator.put("arriba", DirectionGenerator.DIRECTION_UP_KEY);
		this.directionTranslator.put("abajo", DirectionGenerator.DIRECTION_DOWN_KEY);
		this.directionTranslator.put("izquierda", DirectionGenerator.DIRECTION_LEFT_KEY);
		this.directionTranslator.put("derecha", DirectionGenerator.DIRECTION_RIGHT_KEY);
	}
	
	@Override
	protected String getDirectionNameAttribute() {
		return "direccion";
	}
	
}
