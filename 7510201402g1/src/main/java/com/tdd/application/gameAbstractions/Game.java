package com.tdd.application.gameAbstractions;

import com.tdd.controller.controllerAbstractions.PlayerController;
import com.tdd.model.stage.Labyrinth;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.Item;
import com.tdd.model.stageAbstractions.Protagonist;
import com.tdd.model.stageAbstractions.Stage;
import java.util.List;
import javax.management.AttributeNotFoundException;

public abstract class Game {
	
	private Stage stage;
	private List<Enemy> enemies;
	protected Protagonist protagonist;
	protected PlayerController controller;
	
	public Game(String XMLStagePath) throws AttributeNotFoundException {
		this.stage = new Labyrinth(XMLStagePath);
		this.enemies = this.stage.getEnemies();
		this.protagonist = this.stage.getProtagonist();
		List<Item> items = this.stage.getItems();
		//this.createViews(items); until now, left for next iteration
	}
	
	protected abstract PlayerController createPlayerController();
	
	private void createViews(List<Item> items) {
		throw new UnsupportedOperationException("Not supported yet.");
	}
	
	public void gameloop() {
		this.controller = createPlayerController();
		boolean continuePlaying = false;
		while (!continuePlaying) {
			this.controller.processMovement();
			this.updateEnemies();
			//this.updateViews(); until now, left for next iteration
			continuePlaying = (this.stage.hasItems() && this.protagonist.isAlive());
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
