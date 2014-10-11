package com.tdd.model.helpers;

import com.tdd.model.stageAbstractions.Position;
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
	
	private static XMLConstants CONSTANTS;
	private static boolean CONFIGURED = false;
	
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
            return builder.parse(ClassLoader.getSystemResourceAsStream(XMLpath));
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
        XMLReader.testConfiguration();
		String translatedAttributeName = XMLReader.CONSTANTS.getConstantTranslation(attributeName);
		String attribute = "";
        if (node.hasAttributes()) {
            Node attr = node.getAttributes().getNamedItem(translatedAttributeName);
            if (attr != null) {
                attribute = attr.getNodeValue();
            } else {
                throw new AttributeNotFoundException("No existe el atributo " + translatedAttributeName);
            }
        }
        return attribute;
    }

    public static Integer getIntAttributeValue(Node node, String attribute) throws AttributeNotFoundException {
        return Integer.getInteger(XMLReader.getAttributeValue(node, attribute));
    }

    public static Integer getNodeId(Node node) throws AttributeNotFoundException {
		return getIntAttributeValue(node, XMLConstants.ID);
    }

    public static Position getNodePosition(Node node) throws AttributeNotFoundException {
		int nodeY = getIntAttributeValue(node, XMLConstants.ROW);
        int nodeX = getIntAttributeValue(node, XMLConstants.COLUMN);
        return new Position(nodeX, nodeY);
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

	public static void configureLanguage(XMLConstants gameConstants) {
		XMLReader.CONSTANTS = gameConstants;
		XMLReader.CONFIGURED = true;
	}
	
	private static void testConfiguration() {
		if (!XMLReader.CONFIGURED)
			throw new RuntimeException("XMLReader was not configured correctly");
	}

}
