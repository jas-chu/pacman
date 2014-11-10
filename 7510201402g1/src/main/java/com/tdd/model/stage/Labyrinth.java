package com.tdd.model.stage;

import com.tdd.model.exceptions.NoExistingCellException;
import com.tdd.application.configuration.LevelConfigurationsReader;
import com.tdd.model.helpers.LabyrinthLoader;
import com.tdd.model.cell.cellBuilding.CellBuilder;
import com.tdd.model.enemy.enemyBuilding.EnemyBuilder;
import com.tdd.model.exceptions.BlockedCellException;
import com.tdd.model.exceptions.MalformedXMLException;
import com.tdd.model.exceptions.NoAvailableFactoryException;
import com.tdd.model.helpers.LevelCharactersLoader;
import com.tdd.model.helpers.XMLConstants;
import com.tdd.model.helpers.XMLReader;
import com.tdd.model.itemBuilding.ItemBuilder;
import com.tdd.model.stageAbstractions.Cell;
import com.tdd.model.stageAbstractions.Consumable;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.MovingItem;
import com.tdd.model.stageAbstractions.StaticItem;
import com.tdd.model.stageAbstractions.Position;
import com.tdd.model.stageAbstractions.Protagonist;
import com.tdd.model.stageAbstractions.Stage;
import com.tdd.model.stageAbstractions.StageElement;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.AttributeNotFoundException;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Labyrinth implements Stage {

    private List<StaticItem> staticItems;
	private List<MovingItem> movingItems;
    private List<Enemy> enemies;
    private Protagonist pacman;
    private Integer width;
    private Integer height;
    private Integer nodeWidth;
    private Integer nodeHeight;
    private Position pacmanStart;
    private Position ghostStart;
    private List<List<Cell>> cells;
    private final LabyrinthLoader labyrinthLoader;
    private final LevelCharactersLoader gameCharactersLoader;

    /**
     *
	 * @param givenConfigs
	 * @param XMLStagePath
	 * @param XMLCharactersPath
     * @throws com.tdd.model.exceptions.MalformedXMLException
     */
    public Labyrinth(LevelConfigurationsReader givenConfigs) throws MalformedXMLException {
        this.staticItems = new ArrayList<StaticItem>();
		this.movingItems = new ArrayList<MovingItem>();
        this.enemies = new ArrayList<Enemy>();
        this.labyrinthLoader = new LabyrinthLoader(givenConfigs.getStagePath());
        this.gameCharactersLoader = new LevelCharactersLoader(givenConfigs.getCharactersPath());
        try {
            this.loadInitialLabyrinthConfigurations();
            this.loadCells(givenConfigs);
			this.loadEnemies(givenConfigs);
        } catch (NoAvailableFactoryException | AttributeNotFoundException ex) {
            throw new MalformedXMLException();
        }
    }
	
	private void loadInitialLabyrinthConfigurations() throws AttributeNotFoundException {
        this.width = this.labyrinthLoader.getLabyrinthWidth();
        this.height = this.labyrinthLoader.getLabyrinthHeight();
        this.nodeWidth = this.labyrinthLoader.getNodeWidth();
        this.nodeHeight = this.labyrinthLoader.getNodeHeight();
        this.pacmanStart = this.labyrinthLoader.getPacmanStartPosition();
        this.ghostStart = this.labyrinthLoader.getGhostStartPosition();
    }
	
    private void loadCells(LevelConfigurationsReader givenConfigs) throws AttributeNotFoundException, NoAvailableFactoryException {
        NodeList nodes = this.labyrinthLoader.getNodes();
        CellBuilder cellBuilder = new CellBuilder();
        ItemBuilder itemBuilder = new ItemBuilder();
        this.cells = new ArrayList<List<Cell>>();
        for (int row = 0; row < this.height; row++) {
            List<Cell> mapRow = new ArrayList<Cell>();
            for (int col = 0; col < this.width; col++) {
                Node node = nodes.item(row + col);
                Cell createdCell = cellBuilder.createCell(nodes, node);
                String cellContent = XMLReader.getAttributeValue(node, XMLConstants.CONTENT);
                if (!cellContent.isEmpty()) {
					String translatedCellContent = givenConfigs.getGameConstants().getInvertedItemValueTranslation(cellContent);
                    Consumable item = itemBuilder.createItem(this, createdCell.getPosition(), translatedCellContent, givenConfigs);
					item.addToList(this.staticItems, this.movingItems);
                }
                mapRow.add(createdCell);
            }
            this.cells.add(mapRow);
        }
    }
	
    private void loadEnemies(LevelConfigurationsReader givenConfigs) throws AttributeNotFoundException, NoAvailableFactoryException {
        NodeList ghostsNodes = this.gameCharactersLoader.getGhostNodes();
		if (ghostsNodes == null) return;
		
		EnemyBuilder enemyBuilder = new EnemyBuilder();
		for (int i = 0; i < ghostsNodes.getLength(); i++) {
			Node ghostNode = ghostsNodes.item(i);
			Enemy enemy = enemyBuilder.createEnemy(this, givenConfigs, this.ghostStart, ghostNode);
			this.enemies.add(enemy);
			this.placeEnemyAtHome(enemy);
		}
    }

    @Override
    public void populateWithProtagonist(Protagonist givenProtagonist) {
        this.pacman = givenProtagonist;
		this.pacman.placeOnStage(this, this.pacmanStart);
        this.placeProtagonistAtHome(this.pacman);
    }
	
    @Override
    public Integer getWidth() {
        return this.width;
    }

    @Override
    public Integer getHeight() {
        return this.height;
    }

    @Override
    public Integer getNodeWidth() {
        return this.nodeWidth;
    }

    @Override
    public Integer getNodeHeight() {
        return this.nodeHeight;
    }

    @Override
    public Position getGhostStart() {
        return this.ghostStart;
    }

    @Override
    public Position getPacmanStart() {
        return this.pacmanStart;
    }

    @Override
    public List<List<Cell>> getCells() {
        return this.cells;
    }

    @Override
    public List<StaticItem> getStaticItems() {
        return this.staticItems;
    }
	
	@Override
    public List<MovingItem> getMovingItems() {
        return this.movingItems;
    }
	
    @Override
    public List<Enemy> getEnemies() {
        return this.enemies;
    }

    @Override
    public Protagonist getProtagonist() {
        return this.pacman;
    }

    @Override
    public boolean hasStaticItems() {
        return !(this.staticItems.isEmpty());
    }

    /**
     *
     * @param givenPosition
     * @return
     * @throws com.tdd.model.exceptions.NoExistingCellException
     */
    @Override
    public Cell getCell(Position givenPosition) throws NoExistingCellException {
        int rowIndex = givenPosition.getY();
        int colIndex = givenPosition.getX();
        if (rowIndex < 0 || rowIndex >= this.cells.size()) {
            throw new NoExistingCellException();
        }

        List<Cell> row = this.cells.get(rowIndex);
        if (colIndex < 0 || colIndex >= row.size()) {
            throw new NoExistingCellException();
        }
        return row.get(colIndex);
    }

    /**
     *
     * @param element
     */
    private void removeElementFromCell(StageElement element) throws NoExistingCellException {
        Cell sourceCell = this.getCell(element.getPosition());
        sourceCell.removeElement(element);
    }

    /**
     *
     * @param position
     * @param element
     * @throws BlockedCellException
     * @throws com.tdd.model.exceptions.NoExistingCellException
     */
    @Override
    public void placeElement(Position position, StageElement element) throws BlockedCellException, NoExistingCellException {
        Cell targetCell = this.getCell(position);
        targetCell.testPlaceElement();
		this.removeElementFromCell(element);
        targetCell.placeElement(element);
    }

    /**
     *
     * @param position
     * @param element
     */
    private void forcePlaceElement(Position position, StageElement element) {
        try {
            this.removeElementFromCell(element);
            this.getCell(position).placeElement(element);
        } catch (NoExistingCellException ex) {
            Logger.getLogger(Labyrinth.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @param givenEnemy
     */
    @Override
    public void placeEnemyAtHome(Enemy givenEnemy) {
        this.forcePlaceElement(this.ghostStart, givenEnemy);
    }

    /**
     *
     * @param givenProtagonist
     */
    @Override
    public void placeProtagonistAtHome(Protagonist givenProtagonist) {
        this.forcePlaceElement(this.pacmanStart, givenProtagonist);
    }

    /**
     *
     */
    @Override
    public void turnEnemiesToPrey() {
        for (Enemy enemy : this.enemies) {
            enemy.turnToPrey();
        }
    }
	
	private void removeItem(StageElement item) {
		try {
			this.removeElementFromCell(item);
		} catch (NoExistingCellException ex) {
			Logger.getLogger(Labyrinth.class.getName()).log(Level.SEVERE, null, ex);
		}
	}
	
	@Override
    public void removeStaticItem(StaticItem givenItem) {
		this.removeItem(givenItem);
		this.staticItems.remove(givenItem);
    }
	
	@Override
    public void removeMovingItem(MovingItem givenItem) {
		this.removeItem(givenItem);
		this.movingItems.remove(givenItem);
    }

}
