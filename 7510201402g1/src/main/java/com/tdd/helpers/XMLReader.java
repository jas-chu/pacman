package com.tdd.helpers;

import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.AttributeNotFoundException;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class XMLReader {
	
	/**
	 *
	 * @param XMLpath
	 * @return
	 */
	private static Document getDocument(String XMLpath) {
		try {
            DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            //TODO: Ojo con el ClassLoader que en los test suele no andar
            return  builder.parse(ClassLoader.getSystemResourceAsStream(XMLpath));
        } catch (ParserConfigurationException | SAXException | IOException ex) {
            Logger.getLogger(XMLReader.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
	}
	
    /**
     *
     * @param XMLpath
     * @return
     */
    public static Node getFirstNode(String XMLpath) {
        Document document = XMLReader.getDocument(XMLpath);
		return document.getDocumentElement();
    }

    /**
     *
     * @param XMLpath
     * @param tagName
     * @return list of nodes with name=tagName
     */
    public static NodeList getNodeByName(String XMLpath, String tagName) {
        Document document = XMLReader.getDocument(XMLpath);
		return document.getElementsByTagName(tagName);
    }

    /**
     *
     * @param node
     * @param attributeName
     * @return value
     * @throws javax.management.AttributeNotFoundException
     */
    public static String getAttributeValue(Node node, String attributeName) throws AttributeNotFoundException {
        String attribute = "";
        if (node.hasAttributes()) {
            Node attr = node.getAttributes().getNamedItem(attributeName);
            if (attr != null) {
                attribute = attr.getNodeValue();
            }else{
                throw new  AttributeNotFoundException("No existe el atributo "+attributeName);
            }
        }
        return attribute;
    }
	
}
