package com.tdd.model.stage;

import com.tdd.model.helpers.LabyrinthLoader;
import com.tdd.model.helpers.LabyrinthDischarger;
import com.tdd.model.cell.cellBuilding.CellBuilder;
import com.tdd.model.exceptions.BlockedCellException;
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
import javax.management.AttributeNotFoundException;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class Labyrinth implements Stage {

    private List<Item> items;
    private List<Enemy> enemies;
    private Protagonist pacman;
    private int width;
    private int height;
    private Position pacmanStart;
    private Position ghostStart;
    private List<List<Cell>> cells;
    private final LabyrinthLoader labyrinthLoader;
    private final LabyrinthDischarger labyrinthDischarger;

    public Labyrinth(String XMLpath) throws AttributeNotFoundException {
        this.items = new ArrayList<Item>();
        this.enemies = new ArrayList<Enemy>();
        this.labyrinthLoader = LabyrinthLoader.getLabyrinthLoader(XMLpath);
        this.labyrinthDischarger = LabyrinthDischarger.getLabyrinthDischarger(XMLpath);
        loadInitialLabyrinthConfigurations();
        loadCells();
    }

    private void loadCells() throws AttributeNotFoundException {
        NodeList nodes = this.labyrinthLoader.getNodes();
        CellBuilder cellBuilder = new CellBuilder();

        this.cells = new ArrayList<List<Cell>>();
        for (int row = 0; row < this.height; row++) {
            List<Cell> mapRow = new ArrayList<Cell>();
            for (int col = 0; col < this.width; col++) {
                Node node = nodes.item(row + col);
                Cell createdCell = cellBuilder.createCell(node);
                //TODO-Add Items
                
                mapRow.add(createdCell);
            }
            this.cells.add(mapRow);
        }
    }

    private void loadInitialLabyrinthConfigurations() throws AttributeNotFoundException {
        this.width = this.labyrinthLoader.getLabyrinthWidth();
        this.height = this.labyrinthLoader.getLabyrinthHeigth();
        this.pacman = new Pacman(this, this.labyrinthLoader.getPacmanStartPosition());
        this.ghostStart = this.labyrinthLoader.getGhostStartPosition();
    }

    @Override
    public List<Item> getItems() {
        return items;
    }

    @Override
    public List<Enemy> getEnemies() {
        return enemies;
    }

    @Override
    public Protagonist getProtagonist() {
        return pacman;
    }

    @Override
    public boolean hasItems() {
        return !(this.items.isEmpty());
    }

    private Cell getCell(Position position) {
        int row = position.getY();
        int col = position.getX();
        return this.cells.get(row).get(col);
    }

    private void removeElementFromCell(StageElement element) {
        Cell sourceCell = this.getCell(element.getPosition());
        sourceCell.removeElement(element);
    }

    @Override
    public void placeElement(Position position, StageElement element) throws BlockedCellException {
        this.removeElementFromCell(element);
        Cell targetCell = this.getCell(position);
        targetCell.testPlaceElement();
        targetCell.placeElement(element);
    }

    private void forcePlaceElement(Position position, StageElement element) {
        this.removeElementFromCell(element);
        this.getCell(position).placeElement(element);
    }

    @Override
    public void placeEnemyAtHome(Enemy givenEnemy) {
        this.forcePlaceElement(this.ghostStart, givenEnemy);
    }

    @Override
    public void placeProtagonistAtHome(Protagonist givenProtagonist) {
        this.forcePlaceElement(this.pacmanStart, givenProtagonist);
    }

    @Override
    public boolean protagonistIsInArea(Area area) {
        return this.pacman.isInArea(area);
    }

    @Override
    public void turnEnemiesToPrey() {
        for (Enemy enemy : this.enemies) {
            enemy.turnToPrey();
        }
    }

}
