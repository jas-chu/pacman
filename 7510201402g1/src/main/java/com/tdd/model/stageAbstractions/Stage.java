package com.tdd.model.stageAbstractions;

import com.tdd.model.stage.Pacman;
import java.util.ArrayList;

public interface Stage {
	
	public ArrayList<Item> getItems();
	public ArrayList<Enemy> getEnemies();
	public Pacman getPacman();
	public boolean hasItems();
	
}
