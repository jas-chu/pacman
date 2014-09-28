package com.tdd.model.stage;

import com.tdd.helpers.XMLReader;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.Item;
import com.tdd.model.stageAbstractions.Stage;
import java.util.ArrayList;
import org.w3c.dom.Node;

public class Labyrinth implements Stage {
	
	private ArrayList<Item> items;
	private ArrayList<Enemy> enemies;
	private ArrayList<Wall> walls;
	private Pacman pacman;
	
	public Labyrinth(String XMLpath) {
		Node firstNode = XMLReader.getFirstNode(XMLpath);
		/* TODO:
			Recorrer el nodo y por cada elemento llamar a una instancia factory
			para que me cree la entidad que corresponda y lo agregue a la lista
			adecuada.
		*/
	}
	
	public ArrayList<Item> getItems() {
		return items;
	}
	
	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}
	
	public Pacman getPacman() {
		return pacman;
	}

	public boolean hasItems() {
		return !(this.items.isEmpty());
	}
	
}
