package com.tdd.model.helpers;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerConfigurationException;
import javax.xml.transform.TransformerException;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.NodeList;

/**
 *
 *
 */
public class XMLWriter extends XMLIO {

    private final Document doc;
    private Element root;
    private final String path;

    /**
     *
     * @param xmlPath
     */
    public XMLWriter(String xmlPath) {
        DocumentBuilder docBuilder = XMLIO.getDocumentBuilder();
        this.doc = docBuilder.newDocument();
        this.path = xmlPath;
    }

    /**
     *
     * @return
     */
    public Document getDocument() {
        return this.doc;
    }

    /**
     *
     * @return
     */
    public Element getRoot() {
        return this.root;
    }

    /**
     *
     * @param rootName
     * @param attributes
     */
    public void createRoot(String rootName, HashMap<String, String> attributes) {
        String translatedRootName = XMLWriter.getTranslation(rootName);
        this.root = this.doc.createElement(translatedRootName);
        this.addAttributesToElement(this.root, this.createAttributeList(attributes));
        doc.appendChild(this.root);
    }

    /**
     *
     * @param element
     * @param subElementName
     * @param attributes
     */
    public void addSubElement(Element element, String subElementName, HashMap<String, String> attributes) {
        String translatedSubElementName = XMLWriter.getTranslation(subElementName);
        Element subElement = doc.createElement(translatedSubElementName);
        this.addAttributesToElement(subElement, this.createAttributeList(attributes));
        element.appendChild(subElement);
    }

    /**
     *
     * @param elementName
     * @param attributes
     */
    public void addElementToRoot(String elementName, HashMap<String, String> attributes) {
        this.addSubElement(this.root, elementName, attributes);
    }

    /**
     *
     * @param element
     * @param attributes
     */
    private void addAttributesToElement(Element element, List<Attr> attributes) {
        for (Attr attribute : attributes) {
            element.setAttributeNode(attribute);
        }
    }

    /**
     *
     * @param attributes
     * @return
     */
    private List<Attr> createAttributeList(HashMap<String, String> attributes) {
        List<Attr> attributeList = new ArrayList<>();
        for (Map.Entry<String, String> entrySet : attributes.entrySet()) {
            String translatedKey = XMLWriter.getTranslation(entrySet.getKey());
            String translatedValue = XMLWriter.getTranslation(entrySet.getValue());
            Attr attr = this.doc.createAttribute(translatedKey);
            attr.setValue(translatedValue);
            attributeList.add(attr);
        }
        return attributeList;
    }

    /**
     *
     * @throws TransformerConfigurationException
     * @throws TransformerException
     */
    public void write() throws TransformerConfigurationException, TransformerException {
        TransformerFactory transformerFactory = TransformerFactory.newInstance();
        Transformer transformer = transformerFactory.newTransformer();
        DOMSource source = new DOMSource(this.doc);
        StreamResult result = new StreamResult(new File(this.path));
        transformer.transform(source, result);
    }

    /**
     *
     * @param nodes
     */
    public void addNodesToRoot(NodeList nodes) {
        for (int i = 0; i < nodes.getLength(); i++) {
            this.root.appendChild(nodes.item(i));
        }
    }

    /**
     *
     * @param attributes
     * @param attributeName
     * @param value
     */
    public static void addAttributeToCustomMap(Map<String, String> attributes, String attributeName, String value) {
        String translatedAttributeName = XMLWriter.getTranslation(attributeName);
        attributes.put(translatedAttributeName, value);
    }

    /**
     *
     * @param attributes
     * @param attributeName
     * @param value
     */
    public static void addAttributeToCustomMapWithValueTranslation(HashMap<String, String> attributes, String attributeName, String value) {
        String translatedValue = XMLWriter.getTranslation(value);
        XMLWriter.addAttributeToCustomMap(attributes, attributeName, translatedValue);
    }

    /**
     *
     * @param attributes
     * @param attributeName
     * @param value
     * @param digitsAmount
     */
    public static void addIntAttributeToCustomMap(Map<String, String> attributes, String attributeName, Integer value, Integer digitsAmount) {
        String rawStringValue = value.toString();
        int difference = rawStringValue.length() - digitsAmount;
        String completingZeros = new String();
        for (int i = 0; i < difference; ++i) {
            completingZeros += "0";
        }
        String stringValue = completingZeros + rawStringValue;
        XMLWriter.addAttributeToCustomMap(attributes, attributeName, stringValue);
    }

    /**
     *
     * @param attributes
     * @param attributeName
     * @param value
     */
    static void addBooleanAttributeToCustomMap(HashMap<String, String> attributes, String attributeName, Boolean value) {
        String translatedAttributeName = XMLWriter.getTranslation(attributeName);
        attributes.put(translatedAttributeName, value.toString());
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
        XMLIO.testConfiguration("XMLWriter");
    }

    /**
     *
     * @param attributeName
     * @return
     */
    private static String getTranslation(String attributeName) {
        XMLWriter.testConfiguration();
        return XMLIO.getConstants().getConstantTranslation(attributeName);
    }

}
