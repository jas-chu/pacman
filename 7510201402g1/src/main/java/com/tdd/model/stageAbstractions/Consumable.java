package com.tdd.model.stageAbstractions;

import java.util.List;

public interface Consumable {
	
	public int consume();
	public boolean isConsumed();

	public int getAwardingPoints();
	
	public void addToList(List<StaticItem> staticItems, List<MovingItem> movingItems);
	
}
