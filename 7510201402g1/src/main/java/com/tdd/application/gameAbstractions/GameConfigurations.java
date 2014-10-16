package com.tdd.application.gameAbstractions;

import com.tdd.model.helpers.XMLConstants;
import com.tdd.model.helpers.XMLIO;
import java.util.ArrayList;
import java.util.List;

public class GameConfigurations {
	
	public final XMLConstants XMLGameConstants;
	
	// PATHS
	public String XMLStagePath = "";
	public String XMLCharactersPath = "";
	public String XMLPacmanMovementDirectory = "";
	public String XMLSerializationPath = "";
	
	// GAME PARAMETERS
	public List<Long> ghostAngerWaitingCycles = new ArrayList<Long>();
	public int ghostDeadWaitingCycles = 1;
	public int ghostPreyWaitingCycles = 1;
	public int ghostVision = 1;
    public int ghostIncrementalVision = 1;
	
	public GameConfigurations(XMLConstants givenConstants) {
		this.XMLGameConstants = givenConstants;
		XMLIO.configureLanguage(this.XMLGameConstants);
	}
	
}
