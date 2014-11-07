package com.tdd.model.mocks;

import com.tdd.application.gameAbstractions.GameConfigurations;
import com.tdd.model.cell.ClearCell;
import com.tdd.model.exceptions.BlockedCellException;
import com.tdd.model.exceptions.MalformedXMLException;
import com.tdd.model.stageAbstractions.Area;
import com.tdd.model.stageAbstractions.Cell;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.StaticItem;
import com.tdd.model.stageAbstractions.Position;
import com.tdd.model.stageAbstractions.Protagonist;
import com.tdd.model.stageAbstractions.Stage;
import com.tdd.model.stageAbstractions.StageElement;
import java.util.List;

public class MockStage implements Stage {

    public boolean placeElementMethodCalled = false;
    public boolean placeEnemiesAtHomeMethodCalled = false;
    public boolean placeProtagonistAtHomeMethodCalled = false;
    public boolean turnEnemiesToPreyMethodCalled = false;
    public boolean removeItemMethodCalled = false;

    @Override
    public List<StaticItem> getItems() {
        return null;
    }

    @Override
    public List<Enemy> getEnemies() {
        return null;
    }

    @Override
    public Protagonist getProtagonist() {
        return null;
    }

    @Override
    public boolean hasItems() {
        return false;
    }

    @Override
    public void placeElement(Position position, StageElement element) throws BlockedCellException {
        this.placeElementMethodCalled = true;
        element.setPosition(position);
    }

    @Override
    public void placeEnemyAtHome(Enemy givenEnemy) {
        this.placeEnemiesAtHomeMethodCalled = true;
    }

    @Override
    public void placeProtagonistAtHome(Protagonist givenProtagonist) {
        this.placeProtagonistAtHomeMethodCalled = true;
    }

    @Override
    public boolean protagonistIsInArea(Area area) {
        return false;
    }

    @Override
    public void turnEnemiesToPrey() {
        this.turnEnemiesToPreyMethodCalled = true;
    }

    @Override
    public void removeItem(StaticItem givenItem) {
        this.removeItemMethodCalled = true;
    }

    @Override
    public Cell getCell(Position givenPosition) {
        return new ClearCell(0, givenPosition, null);
    }

    @Override
    public Integer getWidth() {
        return 20;
    }

    @Override
    public Integer getHeight() {
        return 20;
    }

    @Override
    public Integer getNodeWidth() {
        return 40;
    }

    @Override
    public Integer getNodeHeight() {
        return 40;
    }

    @Override
    public Position getGhostStart() {
        return new Position(4, 5);
    }

    @Override
    public Position getPacmanStart() {
        return new Position(8, 10);
    }

    @Override
    public List<List<Cell>> getCells() {
        return null;
    }

    @Override
    public void populateWithEnemies(GameConfigurations givenConfigs) throws MalformedXMLException {

    }

    @Override
    public void populateWithProtagonist() {

    }

}
