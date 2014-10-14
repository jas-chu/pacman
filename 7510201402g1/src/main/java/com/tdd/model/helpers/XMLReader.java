package com.tdd.model.helpers;

import com.tdd.model.stageAbstractions.Position;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
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

public class XMLReader extends XMLIO {
	

    /**
     *
     * @param XMLpath
     * @return
     */
    private static Document getDocument(String XMLpath) {
        DocumentBuilder builder = XMLIO.getDocumentBuilder();
		if (builder == null) return null;
		try {
			return builder.parse(ClassLoader.getSystemResourceAsStream(XMLpath));
		} catch (SAXException | IOException ex) {
			Logger.getLogger(XMLReader.class.getName()).log(Level.SEVERE, null, ex);
		}
		return null;
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
        XMLReader.testConfiguration();
        String translatedAttributeName = XMLIO.getConstants().getConstantTranslation(attributeName);
        String attribute = "";
        if (node.hasAttributes()) {
            Node attr = node.getAttributes().getNamedItem(translatedAttributeName);
            if (attr != null) {
                attribute = attr.getNodeValue();
            } else {
                throw new AttributeNotFoundException("The " + translatedAttributeName + " does not exist");
            }
        }
        return attribute;
    }

    /**
     *
     * @param node
     * @param attribute
     * @return
     * @throws AttributeNotFoundException
     */
    public static Integer getIntAttributeValue(Node node, String attribute) throws AttributeNotFoundException {
        return Integer.getInteger(XMLReader.getAttributeValue(node, attribute));
    }

    /**
     *
     * @param node
     * @return
     * @throws AttributeNotFoundException
     */
    public static Integer getNodeId(Node node) throws AttributeNotFoundException {
        return getIntAttributeValue(node, XMLConstants.ID);
    }

    /**
     *
     * @param node
     * @return
     * @throws AttributeNotFoundException
     */
    public static Position getNodePosition(Node node) throws AttributeNotFoundException {
        int nodeY = getIntAttributeValue(node, XMLConstants.ROW);
        int nodeX = getIntAttributeValue(node, XMLConstants.COLUMN);
        return new Position(nodeX, nodeY);
    }

    /**
     *
     * @param node
     * @param attribute
     * @return
     * @throws AttributeNotFoundException
     */
    public static Boolean getBooleanAttributeValue(Node node, String attribute) throws AttributeNotFoundException {
        return Boolean.getBoolean(XMLReader.getAttributeValue(node, attribute));
    }

    /**
     * TODO REFACTORIZAR
     *
     * @param nodeList
     * @param nodeId
     * @return
     */
    public static Node getNodeById(NodeList nodeList, Integer nodeId) {
        Node node = null;
        int i = 0;
        boolean exists = false;
        while ((i < nodeList.getLength()) && !exists) {
            node = nodeList.item(i);
            try {

                if (XMLReader.getNodeId(node).equals(nodeId)) {
                    exists = true;
                }
            } catch (AttributeNotFoundException ex) {
                Logger.getLogger(XMLReader.class.getName()).log(Level.SEVERE, null, ex);
            }
            i++;

        }

        return node;
    }

    /**
     *
     * @param gameConstants
     */
    public static void configureLanguage(XMLConstants gameConstants) {
        XMLIO.configureLanguage(gameConstants);
    }

    /**
     *
     */
    protected static void testConfiguration() {
        XMLIO.testConfiguration("XMLReader");
    }

    /**
     *
     * @param node
     * @return
     * @throws AttributeNotFoundException
     */
    public static Map<String, String> getNeighboursIds(Node node) throws AttributeNotFoundException {
        Map<String, String> neighbours = new HashMap<>();
        XMLReader.addNeighbourId(neighbours, node, XMLConstants.DIRECTION_UP);
		XMLReader.addNeighbourId(neighbours, node, XMLConstants.DIRECTION_DOWN);
		XMLReader.addNeighbourId(neighbours, node, XMLConstants.DIRECTION_LEFT);
		XMLReader.addNeighbourId(neighbours, node, XMLConstants.DIRECTION_RIGHT);
        return neighbours;
    }
	
	private static void addNeighbourId(Map<String, String> neighbours, Node node, String constant) throws AttributeNotFoundException {
		String id = XMLReader.getAttributeValue(node, constant);
		if (!(id.isEmpty())) neighbours.put(constant, id);
	}

}
