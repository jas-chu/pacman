package com.tdd.model.itemBuilding;

import com.tdd.model.stage.BigDot;
import com.tdd.model.stageAbstractions.Consumable;

public class BigDotFactoryTest extends ItemFactoryTest {

	@Override
	protected ItemFactory createFactory() {
		return new BigDotFactory();
	}

	@Override
	protected Consumable createItemExample() {
		return new BigDot(this.stage, this.position, this.configs.getBigDotPoints());
	}

}