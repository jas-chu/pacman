/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdd.helpers;

import org.junit.Test;
import static org.junit.Assert.*;
import org.w3c.dom.Node;

/**
 *
 * @author agu
 */
public class XMLReaderTest {
    
    public XMLReaderTest() {
    }

    /**
     * Test of getFirstNode method, of class XMLReader.
     */
    @Test
    public void testGetFirstNode() {
        System.out.println("getFirstNode");
        String XMLpath = "";
        Node result = XMLReader.getFirstNode(XMLpath);
        assertNotNull(result);
        // TODO review the generated test code and remove the default call to fail.
        //fail("The test case is a prototype.");
    }
    
    @Test
    public void  testNodes(){
        
    }
    
}
