package com.tdd.model.stage;

import com.tdd.model.helpers.LabyrinthLoader;
import com.tdd.model.helpers.LabyrinthDischarger;
import com.tdd.model.cell.cellBuilding.CellBuilder;
import com.tdd.model.enemy.enemyBuilding.EnemyBuilder;
import com.tdd.model.exceptions.BlockedCellException;
import com.tdd.model.exceptions.NoAvailableFactoryException;
import com.tdd.model.ghost.Ghost;
import com.tdd.model.helpers.GameCharactersLoader;
import com.tdd.model.helpers.XMLConstants;
import com.tdd.model.helpers.XMLReader;
import com.tdd.model.itemBuilding.ItemBuilder;
import com.tdd.model.stageAbstractions.Cell;
import com.tdd.model.stageAbstractions.Area;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.Item;
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

    private List<Item> items;
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
    private final LabyrinthDischarger labyrinthDischarger;
    private final GameCharactersLoader gameCharactersLoader;

    /**
     *
     * @param xmlLabyrinthPath
     * @param xmlCharactersPath
     * @throws AttributeNotFoundException
     */
    public Labyrinth(String xmlLabyrinthPath, String xmlCharactersPath) throws AttributeNotFoundException {
        this.items = new ArrayList<Item>();
        this.enemies = new ArrayList<Enemy>();
        this.labyrinthLoader = LabyrinthLoader.getLabyrinthLoader(xmlLabyrinthPath);
        this.labyrinthDischarger = LabyrinthDischarger.getLabyrinthDischarger(this);
        this.gameCharactersLoader = GameCharactersLoader.getCharactersLoader(xmlCharactersPath);
        upLoadInitialLabyrinthConfigurations();
		try {
			upLoadCells();
		} catch (NoAvailableFactoryException ex) {
			// TODO: should throw exception of another class
		}
        upLoadCharacters();
    }

    /**
     *
     * @throws AttributeNotFoundException
     */
    private void upLoadCells() throws AttributeNotFoundException, NoAvailableFactoryException {
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
                    this.items.add(itemBuilder.createItem(this, createdCell.getPosition(), cellContent));
                }
                mapRow.add(createdCell);
            }
            this.cells.add(mapRow);
        }
    }

    /**
     *
     */
    private void upLoadCharacters() {
		this.pacman = new Pacman(this, this.pacmanStart);
        this.upLoadGhost();
    }

    /**
     *
     */
    private void upLoadGhost() {
        NodeList ghostsNodes = this.gameCharactersLoader.getGhostNodes();
        EnemyBuilder enemyBuilder = new EnemyBuilder();
        for (int i = 0; i < ghostsNodes.getLength(); i++) {
            try {
                Node ghostNode = ghostsNodes.item(i);
                String sense = XMLReader.getAttributeValue(ghostNode, XMLConstants.SENSE);
                String personality = XMLReader.getAttributeValue(ghostNode, XMLConstants.PERSONALITY);
                String status = XMLReader.getAttributeValue(ghostNode, XMLConstants.STATUS);                
                this.enemies.add(enemyBuilder.createEnemy(this, ghostStart, status, sense, personality));
            } catch (AttributeNotFoundException ex) {
                Logger.getLogger(Labyrinth.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     *
     * @throws AttributeNotFoundException
     */
    private void upLoadInitialLabyrinthConfigurations() throws AttributeNotFoundException {
        this.width = this.labyrinthLoader.getLabyrinthWidth();
        this.height = this.labyrinthLoader.getLabyrinthHeigth();
        this.nodeWidth = this.labyrinthLoader.getNodeWidth();
        this.nodeHeight = this.labyrinthLoader.getNodeHeight();
        this.pacmanStart = this.labyrinthLoader.getPacmanStartPosition();
        this.ghostStart = this.labyrinthLoader.getGhostStartPosition();
    }

    /**
     *
     * @return
     */
    public Integer getWidth() {
        return this.width;
    }

    /**
     *
     * @return
     */
    public Integer getHeight() {
        return this.height;
    }

    public Integer getNodeWidth() {
        return this.nodeWidth;
    }

    public Integer getNodeHeight() {
        return this.nodeHeight;
    }

    /**
     *
     * @return
     */
    public Position getGhostStart() {
        return this.ghostStart;
    }

    /**
     *
     * @return
     */
    public Position getPacmanStart() {
        return this.pacmanStart;
    }

    /**
     *
     * @return
     */
    public List<List<Cell>> getCells() {
        return this.cells;
    }

    /**
     *
     * @return
     */
    @Override
    public List<Item> getItems() {
        return items;
    }

    /**
     *
     * @return
     */
    @Override
    public List<Enemy> getEnemies() {
        return enemies;
    }

    /**
     *
     * @return
     */
    @Override
    public Protagonist getProtagonist() {
        return pacman;
    }

    /**
     *
     * @return
     */
    @Override
    public boolean hasItems() {
        return !(this.items.isEmpty());
    }

    /**
     *
     * @param position
     * @return
     */
    private Cell getCell(Position position) {
        int row = position.getY();
        int col = position.getX();
        return this.cells.get(row).get(col);
    }

    /**
     *
     * @param element
     */
    private void removeElementFromCell(StageElement element) {
        Cell sourceCell = this.getCell(element.getPosition());
        sourceCell.removeElement(element);
    }

    /**
     *
     * @param position
     * @param element
     * @throws BlockedCellException
     */
    @Override
    public void placeElement(Position position, StageElement element) throws BlockedCellException {
        this.removeElementFromCell(element);
        Cell targetCell = this.getCell(position);
        targetCell.testPlaceElement();
        targetCell.placeElement(element);
    }

    /**
     *
     * @param position
     * @param element
     */
    private void forcePlaceElement(Position position, StageElement element) {
        this.removeElementFromCell(element);
        this.getCell(position).placeElement(element);
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
     * @param area
     * @return
     */
    @Override
    public boolean protagonistIsInArea(Area area) {
        return this.pacman.isInArea(area);
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

}
