package com.tdd.model.stageAbstractions;

import com.tdd.model.exceptions.BlockedCellException;
import com.tdd.model.exceptions.NoExistingCellException;
import java.util.List;

public interface Stage {

    public void populateWithProtagonist(Protagonist givenProtagonist);

    public List<StaticItem> getStaticItems();
	public List<MovingItem> getMovingItems();
    public List<Enemy> getEnemies();
    public Protagonist getProtagonist();

    public Integer getWidth();
    public Integer getHeight();
    public Integer getNodeWidth();
    public Integer getNodeHeight();
    public Position getGhostStart();
    public Position getPacmanStart();

    public List<List<Cell>> getCells();
	public Cell getCell(Position givenPosition) throws NoExistingCellException;
	
	public boolean hasStaticItems();
	
    public void placeElement(Position position, StageElement element) throws BlockedCellException, NoExistingCellException;
    public void placeEnemyAtHome(Enemy givenEnemy);
    public void placeProtagonistAtHome(Protagonist givenProtagonist);
	
	public void removeItem(StaticItem givenItem);
    public void turnEnemiesToPrey();
	
}
