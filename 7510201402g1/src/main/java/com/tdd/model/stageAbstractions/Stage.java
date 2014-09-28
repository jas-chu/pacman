package com.tdd.model.stageAbstractions;

import com.tdd.model.exceptions.BlockedCellException;
import com.tdd.model.ghost.Ghost;
import com.tdd.model.stage.Pacman;
import java.util.ArrayList;

public interface Stage {
	
	public ArrayList<Item> getItems();
	public ArrayList<Enemy> getEnemies();
	public Pacman getPacman();
	public boolean hasItems();

	public void placeElement(Position position, StageElement element) throws BlockedCellException;
	
}
