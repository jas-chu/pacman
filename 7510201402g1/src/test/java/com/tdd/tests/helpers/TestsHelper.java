package com.tdd.tests.helpers;

import com.tdd.application.configuration.LevelConfigurations;
import com.tdd.model.helpers.XMLConstants;
import com.tdd.model.helpers.XMLIO;
import com.tdd.model.helpers.XMLReader;
import com.tdd.model.languageTools.SpanishXMLConstants;
import org.w3c.dom.NodeList;

public class TestsHelper {
	
	public static XMLConstants createGameConstants() {
		XMLConstants constants = new SpanishXMLConstants();
		XMLIO.configureLanguage(constants);
		return constants;
	}
	
	public static NodeList getLevelNodes() {
		return XMLReader.getNodeByName("./juegos/tests/juegoTest.xml", XMLConstants.LEVEL);
	}
	
	public static LevelConfigurations createLevelConfigurations(int level) {
		XMLConstants constants = TestsHelper.createGameConstants();
		NodeList levelNodes = TestsHelper.getLevelNodes();
		return new LevelConfigurations(constants, levelNodes.item(level));
	}
	
}
