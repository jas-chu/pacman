package com.tdd.application.gameAbstractions;

public abstract class XMLConductedGame extends Game {
	
	protected String XMLPacmanDirectory;
	protected String PacmanFilePrefix;
	
	public XMLConductedGame(String XMLStagePath, String givenXMLPacmanDirectory, String givenPacmanFilePrefix) {
		super(XMLStagePath);
		this.XMLPacmanDirectory = givenXMLPacmanDirectory;
		this.PacmanFilePrefix = givenPacmanFilePrefix;
	}

}
