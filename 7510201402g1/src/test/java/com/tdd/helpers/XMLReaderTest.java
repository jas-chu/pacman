/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tdd.helpers;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 * @author Agrojas
 */
public class XMLReaderTest {
    
    public XMLReaderTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of getFirstNode method, of class XMLReader.
     */
    @Test
    public void testGetFirstNode() {
        System.out.println("getFirstNode");
        String XMLpath = "";
        Node expResult = null;
        Node result = XMLReader.getFirstNode(XMLpath);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getNodeByName method, of class XMLReader.
     */
    @Test
    public void testGetNodeByName() {
        System.out.println("getNodeByName");
        String XMLpath = "";
        String tagName = "";
        NodeList expResult = null;
        NodeList result = XMLReader.getNodeByName(XMLpath, tagName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getAttributeValue method, of class XMLReader.
     */
    @Test
    public void testGetAttributeValue() throws Exception {
        System.out.println("getAttributeValue");
        Node node = null;
        String attributeName = "";
        String expResult = "";
        String result = XMLReader.getAttributeValue(node, attributeName);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
