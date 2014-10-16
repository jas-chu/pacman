package com.tdd.application.gameAbstractions;

import com.tdd.controller.controllerAbstractions.PlayerController;
import com.tdd.model.exceptions.MalformedXMLException;
import com.tdd.model.exceptions.NoAvailableFactoryException;
import com.tdd.model.helpers.LabyrinthSerializer;
import com.tdd.model.stage.Labyrinth;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.Item;
import com.tdd.model.stageAbstractions.Protagonist;
import com.tdd.model.stageAbstractions.Stage;
import java.util.List;
import javax.management.AttributeNotFoundException;

public abstract class Game {

    protected GameConfigurations configs;
    private Stage stage;
    private List<Enemy> enemies = null;
    protected Protagonist protagonist = null;
    protected PlayerController controller = null;
	private LabyrinthSerializer labyrinthSerializer;

    public Game(GameConfigurations givenConfigs) throws MalformedXMLException {
		this.configs = givenConfigs;
        this.stage = new Labyrinth(this.configs);
		this.populateMap();
        List<Item> items = this.stage.getItems();
        this.labyrinthSerializer = new LabyrinthSerializer(this.stage, this.configs.XMLSerializationPath, this.configs.XMLGameConstants);
    }

    protected abstract PlayerController createPlayerController();
	
	protected void populateMap() throws MalformedXMLException {
		this.createEnemies();
		this.createProtagonist();
	}
	
	protected void createEnemies() throws MalformedXMLException {
		this.stage.populateWithEnemies(this.configs);
		this.enemies = this.stage.getEnemies();
	}
	
	protected void createProtagonist() {
		this.stage.populateWithProtagonist();
        this.protagonist = this.stage.getProtagonist();
	}
	
	protected boolean isEndOfGame() {
		return (this.stage.hasItems() && this.protagonist.isAlive());
	}
	
    public void gameloop() {
		this.controller = createPlayerController();
        boolean continuePlaying = false;
		long i = 1;
        while (!continuePlaying) {
            this.controller.processMovement();
            this.updateEnemies();
            this.serializeGame(i);
            continuePlaying = this.isEndOfGame();
			++i;
        }
    }

    private void updateEnemies() {
		if (this.enemies == null) return;
        for (Enemy enemy : this.enemies) {
            enemy.move();
        }
    }

    private void serializeGame(long cycle) {
        this.labyrinthSerializer.serialize(cycle);
    }

}
