package com.tdd.application.gameAbstractions;

import com.tdd.application.configuration.LevelConfigurationsReader;
import com.tdd.controller.controllerAbstractions.PlayerController;
import com.tdd.model.exceptions.MalformedXMLException;
import com.tdd.model.stage.Labyrinth;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.MovingItem;
import com.tdd.model.stageAbstractions.Protagonist;
import com.tdd.model.stageAbstractions.Stage;
import com.tdd.model.stageAbstractions.StaticItem;
import com.tdd.view.manager.ViewManager;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

public abstract class GameLevel {

    protected LevelConfigurationsReader configs;
    private Stage stage;
    private List<Enemy> enemies;
    private List<MovingItem> movingItems;
    private List<StaticItem> staticItems;
    protected Protagonist protagonist = null;
    protected long ticks = 1;
    protected ViewManager viewManager;

    public GameLevel(LevelConfigurationsReader givenConfigs) throws MalformedXMLException {
        this.configs = givenConfigs;
        this.createModel();
    }

    private void createModel() throws MalformedXMLException {
        this.stage = new Labyrinth(this.configs);
        this.enemies = this.stage.getEnemies();
        this.movingItems = this.stage.getMovingItems();
        this.staticItems = this.stage.getStaticItems();
    }

    private void createViews() {
        this.viewManager.setConfigValues(this.stage.getWidth(), this.stage.getHeight(),
        this.stage.getNodeWidth(), this.stage.getNodeHeight());
        this.viewManager.createCellsView(this.stage.getCells());
		for (Enemy enemy : this.enemies)
			this.viewManager.createEnemy(enemy);
        this.viewManager.createItemViews(this.staticItems, this.movingItems);

    }

    public void populateWithProtagonist(Protagonist givenProtagonist) {
        PlayerController controller = this.createPlayerController();
        this.populateWithProtagonist(givenProtagonist, controller);
    }

    public void populateWithProtagonist(Protagonist givenProtagonist, PlayerController givenController) {
        if (givenProtagonist == null) {
            return;
        }

        this.protagonist = givenProtagonist;
        this.protagonist.setController(givenController);
        this.protagonist.setSpeed(this.configs.getProtagonistSpeed());
        this.stage.populateWithProtagonist(givenProtagonist);
        this.createProtagonistView();
    }

    private void createProtagonistView() {
        this.viewManager.createProtagonist(this.getProtagonist());
        this.viewManager.createScore(this.getProtagonist());
    }

    protected abstract PlayerController createPlayerController();

    public List<Enemy> getEnemies() {
        return this.enemies;
    }

    public Protagonist getProtagonist() {
        return this.protagonist;
    }

    public boolean isEndOfLevel() {
        if (this.protagonist == null) {
            return true;
        }
        return !(this.stage.hasStaticItems() && this.protagonist.isAlive());
    }

    public void levelLoop() {
        boolean endOfLevel = false;
        while (!endOfLevel) {
            this.updateModel();
            this.updateViews();
            endOfLevel = this.isEndOfLevel();
            ++(this.ticks);
            try {
                Thread.sleep(200);
            } catch (InterruptedException ex) {
                Logger.getLogger(GameLevel.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    private void updateModel() {
        if (this.protagonist != null) {
            this.protagonist.move();
            if (protagonist.hasChanged()) {
                protagonist.notifyObservers();
            }
        }
        for (Enemy enemy : this.enemies) {
            enemy.move();
            if (enemy.hasChanged()) {
                enemy.notifyObservers();
            }

        }
        for (MovingItem item : this.movingItems) {
            item.move();
            if (item.hasChanged()) {
                item.notifyObservers();
            }
        }
    }

    private void updateViews() {
        this.viewManager.reLoadItemsViews(this.staticItems);
        this.viewManager.updateViews();        
    }

    public void setViewManager(ViewManager viewManager) {
        if (this.viewManager != null) {
            return;
        }
        this.viewManager = viewManager;
        this.createViews();
    }

}
