package com.tdd.model.helpers;

import com.tdd.model.stageAbstractions.Cell;
import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
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
public class XMLWriter {

    private final Document doc;
    private Element root;
    private final String path;

    /**
     *
     * @param xmlPath
     */
    public XMLWriter(String xmlPath) {
        DocumentBuilderFactory docFactory = DocumentBuilderFactory.newInstance();
        DocumentBuilder docBuilder = null;
        try {
            docBuilder = docFactory.newDocumentBuilder();
        } catch (ParserConfigurationException ex) {
            Logger.getLogger(XMLWriter.class.getName()).log(Level.SEVERE, null, ex);
        }
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
        this.root = this.doc.createElement(rootName);
        this.createAttributeList(attributes);
        doc.appendChild(this.root);
    }

    /**
     *
     * @param element
     * @param subElementName
     * @param attributes
     */
    public void addSubElement(Element element, String subElementName, HashMap<String, String> attributes) {
        Element subElement = doc.createElement(subElementName);
        this.addAttributesToElement(subElement, this.createAttributeList(attributes));
        element.appendChild(subElement);
    }

    /**
     *
     * @param elementName
     * @param attributes
     */
    public void addElementToRoot(String elementName, HashMap<String, String> attributes) {
        Element element = doc.createElement(elementName);
        this.addAttributesToElement(element, this.createAttributeList(attributes));
        this.root.appendChild(element);
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
            Attr attr = this.doc.createAttribute(entrySet.getKey());
            attr.setValue(entrySet.getValue());
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
    
    
    public void addNodesToRoot(NodeList nodes) {
        for (int i = 0; i < nodes.getLength(); i++) {
            this.root.appendChild(nodes.item(i));
        }
    }

    
}
