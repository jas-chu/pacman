package com.tdd.helpers;

import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import org.w3c.dom.Document;
import org.w3c.dom.Node;

public class LectorXML {
	
	
	public static Node getNodoRaiz(String rutaXML) {
		try {
			DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = factory.newDocumentBuilder();
			Document document = builder.parse(ClassLoader.getSystemResourceAsStream(rutaXML));
			return document.getDocumentElement();
		} catch (Exception ex) {
			Logger.getLogger(LectorXML.class.getName()).log(Level.SEVERE, null, ex);
			return null;
		}
	}
	
}
