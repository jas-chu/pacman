package com.tdd.model.helpers;

import com.tdd.model.languageTools.SpanishXMLConstants;
import com.tdd.model.stageAbstractions.Position;
import java.io.File;
import java.util.Map;
import javax.management.AttributeNotFoundException;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class XMLReaderTest {
    
	private XMLConstants constants;
	private String XMLpath;
	private Node root;
	private NodeList childrenNodes;
	
	@Before
    public void setUp() {
		this.constants = new SpanishXMLConstants();
		XMLReader.configureLanguage(constants);
		this.XMLpath  = System.getProperty("user.dir") + File.separator + "doc";
		this.XMLpath += File.separator + "xmls" + File.separator + "xmls";
		this.XMLpath += File.separator + "laberintos" + File.separator + "LaberintoSimple.xml";
		
		this.root = XMLReader.getFirstNode(this.XMLpath);
		this.childrenNodes = XMLReader.getNodeByName(this.XMLpath, "nodo");
	}
    
    @Test
    public void getFirstNode() {
		Node firstNode = XMLReader.getFirstNode(this.XMLpath);
		assertEquals(firstNode.getNodeName(), "laberinto");
    }

    @Test
    public void getNodeByName() {
        NodeList nodes = XMLReader.getNodeByName(this.XMLpath, "laberinto");
		assertTrue(nodes.getLength() == 1);
		assertEquals(nodes.item(0).getNodeName(), "laberinto");
		
		NodeList allChildrenNodes = XMLReader.getNodeByName(this.XMLpath, "nodo");
		for (int i = 0 ; i < allChildrenNodes.getLength() ; ++i)
			assertEquals(allChildrenNodes.item(i).getNodeName(), "nodo");
    }
	
    @Test
    public void getAttributeValue() throws AttributeNotFoundException {
		String result = XMLReader.getAttributeValue(this.root, XMLConstants.HEIGHT);
		assert(result.equals("19"));
    }
	
	@Test
    public void getIntAttributeValue() throws AttributeNotFoundException {
		Integer result = XMLReader.getIntAttributeValue(this.root, XMLConstants.HEIGHT);
		assert(result == 19);
    }
	
	@Test
    public void getNodeId() throws AttributeNotFoundException {
		Integer id = XMLReader.getNodeId(this.childrenNodes.item(0));
		assert(id == 0);
    }
	
	@Test
    public void getNodePosition() throws AttributeNotFoundException {
		Position position = XMLReader.getNodePosition(this.childrenNodes.item(3));
		Position expectedPosition = new Position (3,0);
		assert(position.equals(expectedPosition));
    }
	
	@Test
    public void getNodeById() {
		try {
			Node node = XMLReader.getNodeById(this.childrenNodes, 5);
			Integer id = XMLReader.getNodeId(node);
			assert(id == 5);
		} catch (AttributeNotFoundException ex) {
			fail();
		}
    }
	
    @Test
	public void getNeighboursIds() throws AttributeNotFoundException {
		Node node = XMLReader.getNodeById(this.childrenNodes, 104);
		Map<String, String> neighbours = XMLReader.getNeighboursIds(node);
		assert(neighbours.get(XMLConstants.DIRECTION_LEFT).equals("0103"));
		assert(neighbours.get(XMLConstants.DIRECTION_RIGHT).equals("0105"));
		assert(neighbours.get(XMLConstants.DIRECTION_DOWN).equals("0204"));
		assertFalse(neighbours.containsKey(XMLConstants.DIRECTION_UP));
	}
	
}
