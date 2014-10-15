package com.tdd.model.stageAbstractions;

import com.tdd.model.exceptions.BlockedCellException;
import java.util.List;

public interface Stage {
	
	public List<Item> getItems();
	public List<Enemy> getEnemies();
	public Protagonist getProtagonist();
        public Cell getCell(Position givenPosition);
	public boolean hasItems();
	
	public void placeElement(Position position, StageElement element) throws BlockedCellException;
	public void placeEnemyAtHome(Enemy givenEnemy);
	public void placeProtagonistAtHome(Protagonist givenProtagonist);
	public boolean protagonistIsInArea(Area area);

	public void turnEnemiesToPrey();

	public void removeItem(Item givenItem);
	
}
