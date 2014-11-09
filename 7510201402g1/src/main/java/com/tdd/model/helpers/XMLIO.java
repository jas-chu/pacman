package com.tdd.model.helpers;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

public class XMLIO {
	private static XMLConstants CONSTANTS;
	private static boolean CONFIGURED;
	
	protected static DocumentBuilder getDocumentBuilder() {
		DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
		try {
			return docFactory.newDocumentBuilder();
		} catch (ParserConfigurationException ex) {
			Logger.getLogger(XMLIO.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
	}
	
	public static void configureLanguage(XMLConstants gameConstants) {
		if (!(XMLIO.CONFIGURED)) {
			XMLIO.CONSTANTS = gameConstants;
			XMLIO.CONFIGURED = true;
		}
    }

    protected static void testConfiguration(String device) {
        if (!XMLIO.CONFIGURED) {
            throw new RuntimeException(device + " was not configured correctly");
        }
    }
	
	protected static XMLConstants getConstants() {
		return XMLIO.CONSTANTS;
	}
	
}
