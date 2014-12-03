package com.tdd.model.itemBuilding;

import com.tdd.model.stage.Dot;
import com.tdd.model.stageAbstractions.Consumable;

public class DotFactoryTest extends ItemFactoryTest {

	@Override
	protected ItemFactory createFactory() {
		return new DotFactory();
	}

	@Override
	protected Consumable createItemExample() {
		return new Dot(this.stage, this.position, this.configs.getDotPoints());
	}

}