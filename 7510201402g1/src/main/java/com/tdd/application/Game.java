package com.tdd.application;

import com.tdd.model.stage.Labyrinth;
import com.tdd.model.stage.Pacman;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.Item;
import java.util.ArrayList;

public class Game {
	
	private Labyrinth labyrinth;
	private ArrayList<Enemy> enemies;
	private Pacman pacman;
	private PlayerController controller;
	
	public Game(String XMLpath) {
		this.labyrinth = new Labyrinth(XMLpath);
		this.enemies = this.labyrinth.getEnemies();
		this.pacman = this.labyrinth.getPacman();
		ArrayList<Item> items = this.labyrinth.getItems();
		
		this.controller = new PlayerController(this.pacman);
		this.createViews(items);
	}

	private void createViews(ArrayList<Item> items) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
	public void gameloop() {
		boolean continuePlaying = false;
		while (!continuePlaying) {
			this.controller.processMovement();
			this.updateEnemies();
			this.updateViews();
			continuePlaying = (this.labyrinth.hasItems() && this.pacman.isAlive());
		}
	}

	private void updateEnemies() {
		for (Enemy enemigo : this.enemies) {
			enemigo.move();
		}
	}

	private void updateViews() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
}
