package com.tdd.model.stageAbstractions;

import com.tdd.application.gameAbstractions.GameConfigurations;
import com.tdd.model.exceptions.BlockedCellException;
import com.tdd.model.exceptions.MalformedXMLException;
import com.tdd.model.exceptions.NoExistingCellException;
import java.util.List;

public interface Stage {

    public void populateWithEnemies(GameConfigurations givenConfigs) throws MalformedXMLException;

    public void populateWithProtagonist();

    public List<Item> getItems();

    public List<Enemy> getEnemies();

    public Protagonist getProtagonist();

    public Cell getCell(Position givenPosition) throws NoExistingCellException;

    public boolean hasItems();

    public Integer getWidth();

    public Integer getHeight();

    public Integer getNodeWidth();

    public Integer getNodeHeight();

    public Position getGhostStart();

    public Position getPacmanStart();

    public List<List<Cell>> getCells();

    public void placeElement(Position position, StageElement element) throws BlockedCellException, NoExistingCellException;

    public void placeEnemyAtHome(Enemy givenEnemy);

    public void placeProtagonistAtHome(Protagonist givenProtagonist);

    public boolean protagonistIsInArea(Area area);

    public void turnEnemiesToPrey();

    public void removeItem(Item givenItem);

    public Integer getScore();

}
