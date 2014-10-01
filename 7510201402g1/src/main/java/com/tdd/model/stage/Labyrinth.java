package com.tdd.model.stage;

import com.tdd.helpers.XMLReader;
import com.tdd.model.exceptions.BlockedCellException;
import com.tdd.model.ghost.Ghost;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.Item;
import com.tdd.model.stageAbstractions.Position;
import com.tdd.model.stageAbstractions.Stage;
import com.tdd.model.stageAbstractions.StageElement;
import java.util.ArrayList;
import org.w3c.dom.Node;

public class Labyrinth implements Stage {
	
	private ArrayList<Item> items;
	private ArrayList<Enemy> enemies;
	private Pacman pacman;
	
	public Labyrinth(String XMLpath) {
		Node firstNode = XMLReader.getFirstNode(XMLpath);
                
		/* TODO:
			Recorrer el nodo y por cada elemento llamar a una instancia factory
			para que me cree la entidad que corresponda y lo agregue a la lista
			adecuada.
		*/
	}
	
	@Override
	public ArrayList<Item> getItems() {
		return items;
	}
	
	@Override
	public ArrayList<Enemy> getEnemies() {
		return enemies;
	}
	
	@Override
	public Pacman getPacman() {
		return pacman;
	}

	@Override
	public boolean hasItems() {
		return !(this.items.isEmpty());
	}
	
	private void testPlaceElement(Position position) throws BlockedCellException  {
		throw new UnsupportedOperationException("Not supported yet.");
	}
	
	@Override
	public void placeElement(Position position, StageElement element) throws BlockedCellException {
		this.testPlaceElement(position);
		throw new UnsupportedOperationException("Not supported yet.");
	}

	@Override
	public void placeEnemyAtHome(Enemy givenEnemy) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
	
}
