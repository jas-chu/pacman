/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdd.model.stage;

import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.Item;
import com.tdd.model.stageAbstractions.Position;
import com.tdd.model.stageAbstractions.StageElement;
import java.util.ArrayList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author agu
 */
public class LabyrinthTest {
    
    public LabyrinthTest() {
    }

    /**
     * Test of getItems method, of class Labyrinth.
     */
    @Test
    public void testGetItems() {
        System.out.println("getItems");
        Labyrinth instance = null;
        ArrayList<Item> expResult = null;
        ArrayList<Item> result = instance.getItems();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getEnemies method, of class Labyrinth.
     */
    @Test
    public void testGetEnemies() {
        System.out.println("getEnemies");
        Labyrinth instance = null;
        ArrayList<Enemy> expResult = null;
        ArrayList<Enemy> result = instance.getEnemies();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPacman method, of class Labyrinth.
     */
    @Test
    public void testGetPacman() {
        System.out.println("getPacman");
        Labyrinth instance = null;
        Pacman expResult = null;
        Pacman result = instance.getPacman();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of hasItems method, of class Labyrinth.
     */
    @Test
    public void testHasItems() {
        System.out.println("hasItems");
        Labyrinth instance = null;
        boolean expResult = false;
        boolean result = instance.hasItems();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of placeElement method, of class Labyrinth.
     */
    @Test
    public void testPlaceElement() throws Exception {
        System.out.println("placeElement");
        Position position = null;
        StageElement element = null;
        Labyrinth instance = null;
        instance.placeElement(position, element);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of placeEnemyAtHome method, of class Labyrinth.
     */
    @Test
    public void testPlaceEnemyAtHome() {
        System.out.println("placeEnemyAtHome");
        Enemy givenEnemy = null;
        Labyrinth instance = null;
        instance.placeEnemyAtHome(givenEnemy);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
    
}
