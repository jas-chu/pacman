package com.tdd.application.gameLevelFactory;

import com.tdd.application.gameAbstractions.GameLevelFactory;
import com.tdd.model.exceptions.NoAvailableFactoryException;
import com.tdd.model.helpers.XMLConstants;
import com.tdd.tests.helpers.TestsHelper;
import org.junit.Test;
import static org.junit.Assert.*;
import org.w3c.dom.NodeList;

public class GameLevelFactorySearcherTest {
	
	@Test
    public void GameLevelFactorySearcherCreationTest() {
		GameLevelFactorySearcher levelFactorySearcher = new GameLevelFactorySearcher();
		assert(levelFactorySearcher != null);
    }
	
	@Test
	public void test(){
		GameLevelFactorySearcher levelFactorySearcher = new GameLevelFactorySearcher();
		
		XMLConstants constants = TestsHelper.createGameConstants();
		NodeList levelNodes = TestsHelper.getLevelNodes();
		try {
			GameLevelFactory levelFactory = levelFactorySearcher.getFactory(levelNodes.item(0), constants);
			assert(levelFactory != null);
		} catch (NoAvailableFactoryException ex) {
			fail();
		}
	}
	
	
}