package com.tdd.application.gameAbstractions;

import com.tdd.controller.controllerAbstractions.PlayerController;
import com.tdd.model.stage.Labyrinth;
import com.tdd.model.stage.Pacman;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.Item;
import com.tdd.model.stageAbstractions.Stage;
import java.util.ArrayList;

public abstract class Game {
	
	private Stage stage;
	private ArrayList<Enemy> enemies;
	protected Pacman pacman;
	protected PlayerController controller;
	
	public Game(String XMLStagePath) {
		this.stage = new Labyrinth(XMLStagePath);
		this.enemies = this.stage.getEnemies();
		this.pacman = this.stage.getPacman();
		ArrayList<Item> items = this.stage.getItems();
		//this.createViews(items); until now, left for next iteration
	}
	
	protected abstract PlayerController createPlayerController();
	
	private void createViews(ArrayList<Item> items) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
	
	public void gameloop() {
		this.controller = createPlayerController();
		boolean continuePlaying = false;
		while (!continuePlaying) {
			this.controller.processMovement();
			this.updateEnemies();
			//this.updateViews(); until now, left for next iteration
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
