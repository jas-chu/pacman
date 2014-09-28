package com.tdd.application;

import com.tdd.model.stage.Labyrinth;
import com.tdd.model.stage.Pacman;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.Item;
import com.tdd.model.stageAbstractions.Stage;
import java.util.ArrayList;

public class Game {
	
	private Stage stage;
	private ArrayList<Enemy> enemies;
	private Pacman pacman;
	private PlayerController controller;
	
	public Game(String XMLpath) {
		this.stage = new Labyrinth(XMLpath);
		this.enemies = this.stage.getEnemies();
		this.pacman = this.stage.getPacman();
		ArrayList<Item> items = this.stage.getItems();
		
		this.controller = new PlayerController(this.pacman);
		//this.createViews(items); queda para la siguiente iteracion
	}

	private void createViews(ArrayList<Item> items) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
	
	public void gameloop() {
		boolean continuePlaying = false;
		while (!continuePlaying) {
			this.controller.processMovement();
			this.updateEnemies();
			//this.updateViews(); queda para la siguiente iteracion
			continuePlaying = (this.stage.hasItems() && this.pacman.isAlive());
		}
	}

	private void updateEnemies() {
		for (Enemy enemy : this.enemies) {
			enemy.move();
		}
	}

	private void updateViews() {
		throw new UnsupportedOperationException("Not supported yet.");
	}
	
}
