package com.tdd.application.gameAbstractions;

import com.tdd.controller.controllerAbstractions.PlayerController;
import com.tdd.model.exceptions.MalformedXMLException;
import com.tdd.model.stage.Labyrinth;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.MovingItem;
import com.tdd.model.stageAbstractions.StaticItem;
import com.tdd.model.stageAbstractions.Protagonist;
import com.tdd.model.stageAbstractions.Stage;
import java.util.List;

public abstract class GameLevel {

    protected GameConfigurations configs;
    private Stage stage;
    private List<Enemy> enemies;
	private List<MovingItem> movingItems;
    protected Protagonist protagonist = null;
	protected long ticks = 1;

    public GameLevel(GameConfigurations givenConfigs, String XMLStagePath,
					String XMLCharactersPath) throws MalformedXMLException {
		
		this.configs = givenConfigs;
        this.createModel(XMLStagePath, XMLCharactersPath);
		this.createViews();
    }
	
	private void createModel(String XMLStagePath, String XMLCharactersPath) throws MalformedXMLException {
		
		this.stage = new Labyrinth(this.configs, XMLStagePath, XMLCharactersPath);
		this.enemies = this.stage.getEnemies();
		this.movingItems = this.stage.getMovingItems();
	}
	
	private void createViews() {
		// OJO!! NO CREAR NADA DEL PROTAGONIST
		// enemies y moving items son atributos
		List<StaticItem> staticItems = this.stage.getStaticItems();
		throw new UnsupportedOperationException("Not supported yet.");
	}
	
	public void populateWithProtagonist(Protagonist givenProtagonist) {
		if (givenProtagonist == null) return;
		
		this.protagonist = givenProtagonist;
		PlayerController controller = this.createPlayerController();
		this.protagonist.setController(controller);
		this.stage.populateWithProtagonist(givenProtagonist);
		this.createProtagonistView();
	}
	
	private void createProtagonistView() {
		throw new UnsupportedOperationException("Not supported yet.");
	}
	
	protected abstract PlayerController createPlayerController();
	
	public List<Enemy> getEnemies() {
		return this.enemies;
	}

	public Protagonist getProtagonist() {
		return this.protagonist;
	}
	
	public boolean isEndOfLevel() {
		if (this.protagonist == null) return true;
		return !(this.stage.hasStaticItems() && this.protagonist.isAlive());
	}
	
    public void levelLoop() {
		boolean endOfLevel = false;
        while (!endOfLevel) {
			this.updateModel();
			this.updateViews();
			endOfLevel = this.isEndOfLevel();
			++(this.ticks);
        }
    }

    private void updateModel() {
		if (this.protagonist != null) this.protagonist.move();
        for (Enemy enemy : this.enemies) enemy.move();
		for (MovingItem item : this.movingItems) item.move();
    }
	
	private void updateViews() {
		throw new UnsupportedOperationException("Not supported yet.");
	}
	
}