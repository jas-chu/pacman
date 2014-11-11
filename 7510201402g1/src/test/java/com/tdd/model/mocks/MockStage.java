package com.tdd.model.mocks;

import com.tdd.model.cell.ClearCell;
import com.tdd.model.exceptions.BlockedCellException;
import com.tdd.model.stageAbstractions.Cell;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.MovingItem;
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
    public boolean removeStaticItemMethodCalled = false;
    public boolean removeMovingItemMethodCalled = false;

    private MockProtagonist protagonist = new MockProtagonist();

    @Override
    public List<StaticItem> getStaticItems() {
        return null;
    }

    @Override
    public List<MovingItem> getMovingItems() {
        return null;
    }

    @Override
    public List<Enemy> getEnemies() {
        return null;
    }

    @Override
    public void populateWithProtagonist(Protagonist givenProtagonist) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public Protagonist getProtagonist() {
        return this.protagonist;
    }

    @Override
    public boolean hasStaticItems() {
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
    public void turnEnemiesToPrey() {
        this.turnEnemiesToPreyMethodCalled = true;
    }

    @Override
    public void removeStaticItem(StaticItem givenItem) {
        this.removeStaticItemMethodCalled = true;
    }

    @Override
    public void removeMovingItem(MovingItem givenItem) {
        this.removeMovingItemMethodCalled = true;
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

}
