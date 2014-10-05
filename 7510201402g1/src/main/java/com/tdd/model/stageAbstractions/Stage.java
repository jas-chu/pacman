package com.tdd.model.stageAbstractions;

import com.tdd.model.exceptions.BlockedCellException;
import com.tdd.model.stage.Pacman;
import java.util.List;

public interface Stage {
	
	public List<Item> getItems();
	public List<Enemy> getEnemies();
	public Pacman getPacman();
	public boolean hasItems();

	public void placeElement(Position position, StageElement element) throws BlockedCellException;
	public void placeEnemyAtHome(Enemy givenEnemy);
	public void placePacmanAtHome(Pacman givenPacman);
	public boolean pacmanIsInArea(Area area);
	
}
