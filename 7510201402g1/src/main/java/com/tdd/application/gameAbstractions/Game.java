package com.tdd.application.gameAbstractions;

import com.tdd.controller.controllerAbstractions.PlayerController;
import com.tdd.model.exceptions.MalformedXMLException;
import com.tdd.model.exceptions.NoMoreMovementsException;
import com.tdd.model.helpers.GameCharactersSerializer;
import com.tdd.model.helpers.LabyrinthSerializer;
import com.tdd.model.stage.Labyrinth;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.Item;
import com.tdd.model.stageAbstractions.Protagonist;
import com.tdd.model.stageAbstractions.Stage;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class Game {

    protected GameConfigurations configs;
    private Stage stage;
    private List<Enemy> enemies = null;
    protected Protagonist protagonist = null;
    protected PlayerController controller = null;
	private LabyrinthSerializer labyrinthSerializer;
	private GameCharactersSerializer charactersSerializer;
	protected long ticks = 1;

    public Game(GameConfigurations givenConfigs) throws MalformedXMLException {
		this.configs = givenConfigs;
        this.stage = new Labyrinth(this.configs);
		this.populateMap();
		if (this.enemies == null) this.enemies = new ArrayList<Enemy>();
        List<Item> items = this.stage.getItems();
        this.labyrinthSerializer = new LabyrinthSerializer(this.stage, this.configs.XMLSerializationPath, this.configs.XMLGameConstants);
		this.charactersSerializer = new GameCharactersSerializer(this, this.configs.XMLSerializationPath, this.configs.XMLGameConstants);
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
	
	public boolean isEndOfGame() {
		return !(this.stage.hasItems() && this.protagonist.isAlive());
	}
	
    public void gameloop() {
		this.controller = createPlayerController();
        boolean endOfGame = false;
        while (!endOfGame) {
			try {
				this.controller.processMovement();
				this.updateEnemies();
				this.serializeGame();
				endOfGame = this.isEndOfGame();
				++(this.ticks);
			} catch (NoMoreMovementsException ex) {
				endOfGame = true;
			}
        }
    }

    private void updateEnemies() {
        for (Enemy enemy : this.enemies) {
            enemy.move();
        }
    }

    private void serializeGame() {
        this.labyrinthSerializer.serialize(ticks);
		this.charactersSerializer.serialize(ticks);
    }

	public List<Enemy> getEnemies() {
		return this.enemies;
	}

	public Protagonist getProtagonist() {
		return this.protagonist;
	}

}
