package com.tdd.application.gameAbstractions;

import com.tdd.application.configuration.LevelConfigurationsReader;
import com.tdd.controller.controllerAbstractions.PlayerController;
import com.tdd.model.exceptions.MalformedXMLException;
import com.tdd.model.stage.Labyrinth;
import com.tdd.model.stageAbstractions.Cell;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.MovingItem;
import com.tdd.model.stageAbstractions.Protagonist;
import com.tdd.model.stageAbstractions.Stage;
import com.tdd.view.manager.ViewManager;
import java.util.Iterator;
import java.util.List;

public abstract class GameLevel {

    protected LevelConfigurationsReader configs;
    private Stage stage;
    private List<Enemy> enemies;
    private List<MovingItem> movingItems;
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
    }

    private void createViews() {
        for (List<Cell> cells : this.stage.getCells()) {
            for (Cell cell : cells) {
                this.viewManager.createCell(cell);
            }
        }
        this.enemies.forEach(this.viewManager::addObserver);
//        this.stage.getStaticItems().stream().forEach(this.viewManager::addObserver);
//        this.stage.getMovingItems().stream().forEach(this.viewManager::addObserver);

    }

    public void populateWithProtagonist(Protagonist givenProtagonist) {
        if (givenProtagonist == null) {
            return;
        }

        this.protagonist = givenProtagonist;
        PlayerController controller = this.createPlayerController();
        this.protagonist.setController(controller);
        this.protagonist.setSpeed(this.configs.getProtagonistSpeed());
        this.stage.populateWithProtagonist(givenProtagonist);
        this.createProtagonistView();
    }

    private void createProtagonistView() {
        this.viewManager.addObserver(this.getProtagonist());
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
