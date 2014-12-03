package com.tdd.model.itemBuilding;

import com.tdd.application.configuration.LevelConfigurations;
import com.tdd.model.mocks.MockStage;
import com.tdd.model.stageAbstractions.Consumable;
import com.tdd.model.stageAbstractions.Position;
import com.tdd.tests.helpers.TestsHelper;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public abstract class ItemFactoryTest {
	
	ItemFactory factory;
	Consumable itemExample;
	
	MockStage stage;
	Position position;
	LevelConfigurations configs;
	
	@Before
    public void setUp() {
		this.factory = this.createFactory();
		this.stage = new MockStage();
		this.position = new Position(0,0);
		this.configs = TestsHelper.createLevelConfigurations(0);
		this.itemExample = this.createItemExample();
	}
	
	protected abstract ItemFactory createFactory();
	protected abstract Consumable createItemExample();
	
	@Test
	public void createItemTest() {
		Consumable item = this.factory.createItem(stage, position, configs);
		assert(item != null);
		assertEquals(item.getClass(), this.itemExample.getClass());
	}

}