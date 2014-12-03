package com.tdd.model.itemBuilding;

import com.tdd.model.stage.Fruit;
import com.tdd.model.stageAbstractions.Consumable;

public class FruitFactoryTest extends ItemFactoryTest {

	@Override
	protected ItemFactory createFactory() {
		return new FruitFactory();
	}

	@Override
	protected Consumable createItemExample() {
		return new Fruit(this.stage, this.position, this.configs.getFruitPoints(),
						 this.configs.getItemsSpeed(), this.configs.getFruitHiddenCycles());
	}

}