package com.tdd.application.gameAbstractions;

import com.tdd.controller.controllerAbstractions.PlayerController;
import com.tdd.model.exceptions.MalformedXMLException;
import com.tdd.model.helpers.LabyrinthSerializer;
import com.tdd.model.helpers.XMLConstants;
import com.tdd.model.helpers.XMLIO;
import com.tdd.model.stage.Labyrinth;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.Item;
import com.tdd.model.stageAbstractions.Protagonist;
import com.tdd.model.stageAbstractions.Stage;
import java.util.List;

public abstract class Game {

    protected XMLConstants gameConstants;
    private Stage stage;
    private List<Enemy> enemies;
    protected Protagonist protagonist;
    protected PlayerController controller;
	private LabyrinthSerializer labyrinthSerializer;

    public Game(String XMLStagePath, String XMLCharactersPath, String XMLSerializationPath,
			    XMLConstants XMLGameConstants) throws MalformedXMLException {
        
		this.gameConstants = XMLGameConstants;
        XMLIO.configureLanguage(this.gameConstants);
        this.stage = new Labyrinth(XMLStagePath, XMLCharactersPath);
        this.enemies = this.stage.getEnemies();
        this.protagonist = this.stage.getProtagonist();
        List<Item> items = this.stage.getItems();
        this.labyrinthSerializer = new LabyrinthSerializer(this.stage, XMLSerializationPath, this.gameConstants);
    }

    protected abstract PlayerController createPlayerController();

    public void gameloop() {
        this.controller = createPlayerController();
        boolean continuePlaying = false;
		long i = 1;
        while (!continuePlaying) {
            this.controller.processMovement();
            this.updateEnemies();
            this.serializeGame(i);
            continuePlaying = (this.stage.hasItems() && this.protagonist.isAlive());
			++i;
        }
    }

    private void updateEnemies() {
        for (Enemy enemy : this.enemies) {
            enemy.move();
        }
    }

    private void serializeGame(long cycle) {
        this.labyrinthSerializer.serialize(cycle);
    }

}
