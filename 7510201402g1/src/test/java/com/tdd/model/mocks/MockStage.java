package com.tdd.model.mocks;

import com.tdd.model.exceptions.BlockedCellException;
import com.tdd.model.stageAbstractions.Area;
import com.tdd.model.stageAbstractions.Cell;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.Item;
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
    public List<Item> getItems() {
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
    public void removeItem(Item givenItem) {
        this.removeItemMethodCalled = true;
    }

    @Override
    public Cell getCell(Position givenPosition) {
        return null;
    }

}