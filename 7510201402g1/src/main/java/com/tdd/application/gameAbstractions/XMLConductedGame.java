package com.tdd.application.gameAbstractions;

import javax.management.AttributeNotFoundException;

public abstract class XMLConductedGame extends Game {
	
	protected String XMLPacmanDirectory;
	protected String PacmanFilePrefix;
	
	public XMLConductedGame(String XMLStagePath, String givenXMLPacmanDirectory, String givenPacmanFilePrefix) throws AttributeNotFoundException {
		super(XMLStagePath);
		this.XMLPacmanDirectory = givenXMLPacmanDirectory;
		this.PacmanFilePrefix = givenPacmanFilePrefix;
	}

}
