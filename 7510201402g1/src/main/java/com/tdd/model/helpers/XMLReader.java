package com.tdd.model.helpers;

import com.tdd.model.exceptions.NoNodeWithThatNameException;
import com.tdd.model.stageAbstractions.Position;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.AttributeNotFoundException;
import javax.xml.parsers.DocumentBuilder;
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
			InputStream file = new FileInputStream(XMLpath);
			return builder.parse(file);
		} catch (SAXException | IOException ex) {
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
		String translatedTagName = XMLReader.getTranslation(tagName);
        return document.getElementsByTagName(translatedTagName);
    }
	
	/**
     *
	 * @param givenNode
     * @param tagName
     * @return first node with name=tagName
     */
    public static List<Node> getNodeByName(Node givenNode, String tagName) {
        NodeList children = givenNode.getChildNodes();
		String translatedTagName = XMLReader.getTranslation(tagName);
		
		List<Node> filteredChildren = new ArrayList<Node>();
		for (int i = 0 ; i < children.getLength() ; ++i) {
			Node child = children.item(i);
			if (child.getNodeName().equals(translatedTagName)) {
				filteredChildren.add(child);
			}
		}
		return filteredChildren;
    }
	
	/**
     *
	 * @param givenNode
     * @param tagName
     * @return first node with name=tagName
	 * @throws com.tdd.model.exceptions.NoNodeWithThatNameException
     */
    public static Node getFirstNodeWithName(Node givenNode, String tagName) throws NoNodeWithThatNameException {
        NodeList children = givenNode.getChildNodes();
		String translatedTagName = XMLReader.getTranslation(tagName);
		
		for (int i = 0 ; i < children.getLength() ; ++i) {
			Node child = children.item(i);
			if (child.getNodeName().equals(translatedTagName)) {
				return child;
			}
		}
        throw new NoNodeWithThatNameException();
    }
	
	public static String getNodeValue(Node node) {
		NodeList nodeList = node.getChildNodes();
		Node nValue = (Node) nodeList.item(0);
		return nValue.getNodeValue();
	}
	
	/**
     *
	 * @param givenNode
     * @param tagName
     * @return string value of first node with name=tagName
	 * @throws com.tdd.model.exceptions.NoNodeWithThatNameException
     */
    public static String getFirstNodeValueWithName(Node givenNode, String tagName) throws NoNodeWithThatNameException {
        Node node = XMLReader.getFirstNodeWithName(givenNode, tagName);
		return XMLReader.getNodeValue(node);
    }
	
	/**
     *
	 * @param givenNode
     * @param tagName
     * @return integer value of first node with name=tagName
	 * @throws com.tdd.model.exceptions.NoNodeWithThatNameException
     */
    public static Integer getFirstNodeIntValueWithName(Node givenNode, String tagName) throws NoNodeWithThatNameException {
        String value = XMLReader.getFirstNodeValueWithName(givenNode, tagName);
		return Integer.parseInt(value);
    }
	
	/**
     *
	 * @param givenNode
     * @param tagName
     * @return long value of first node with name=tagName
	 * @throws com.tdd.model.exceptions.NoNodeWithThatNameException
     */
    public static Long getFirstNodeLongValueWithName(Node givenNode, String tagName) throws NoNodeWithThatNameException {
        String value = XMLReader.getFirstNodeValueWithName(givenNode, tagName);
		return Long.parseLong(value);
    }
	
    /**
     *
     * @param node
     * @param attributeName
     * @return value
     * @throws javax.management.AttributeNotFoundException
     */
    public static String getAttributeValue(Node node, String attributeName) throws AttributeNotFoundException {
        String translatedAttributeName = XMLReader.getTranslation(attributeName);
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
        String value = XMLReader.getAttributeValue(node, attribute);
		return Integer.parseInt(value);
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
     * @param nodeList
     * @param nodeId
     * @return
     */
    public static Node getNodeById(NodeList nodeList, Integer nodeId) {
		for (int i = 0 ; i < nodeList.getLength() ; ++i) {
			Node node = nodeList.item(i);
			try {
                if (XMLReader.getNodeId(node).equals(nodeId)) return node;
            } catch (AttributeNotFoundException ex) {
                Logger.getLogger(XMLReader.class.getName()).log(Level.SEVERE, null, ex);
            }
		}
		return null;
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
	
	private static String getTranslation(String attributeName) {
		XMLReader.testConfiguration();
		return XMLIO.getConstants().getConstantTranslation(attributeName);
	}
	
    /**
     *
     * @param node
     * @return
     * @throws AttributeNotFoundException
     */
    public static Map<String, Position> getNeighbours(Node node) throws AttributeNotFoundException {
        Map<String, Position> neighbours = new HashMap<>();
        XMLReader.addNeighbourId(neighbours, node, XMLConstants.DIRECTION_UP);
		XMLReader.addNeighbourId(neighbours, node, XMLConstants.DIRECTION_DOWN);
		XMLReader.addNeighbourId(neighbours, node, XMLConstants.DIRECTION_LEFT);
		XMLReader.addNeighbourId(neighbours, node, XMLConstants.DIRECTION_RIGHT);
        return neighbours;
    }
	
	private static void addNeighbourId(Map<String, Position> neighbours, Node node, String constant) throws AttributeNotFoundException {
		String id = XMLReader.getAttributeValue(node, constant);
		if (!(id.isEmpty())) neighbours.put(constant, new Position(id));
	}

}
