package com.tdd.model.stage;

import com.tdd.helpers.XMLConstants;
import com.tdd.helpers.XMLReader;
import com.tdd.model.cell.cellBuilding.CellBuilder;
import com.tdd.model.exceptions.BlockedCellException;
import com.tdd.model.stageAbstractions.Cell;
import com.tdd.model.stageAbstractions.Area;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.Item;
import com.tdd.model.stageAbstractions.Position;
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
    private Pacman pacman;
    private int width;
    private int height;
    private Position pacmanStart;
    private Position ghostStart;
    private List<List<Cell>> cells;

    public Labyrinth(String XMLpath) throws AttributeNotFoundException {
		this.items = new ArrayList<Item>();
		this.enemies = new ArrayList<Enemy>();
        loadInitialLabyrinthConfigurations(XMLpath);
        loadCells(XMLpath);
    }

    private void loadCells(String XMLpath) throws AttributeNotFoundException {
        NodeList nodes = XMLReader.getNodeByName(XMLpath,XMLConstants.NODE);
		CellBuilder cellBuilder = new CellBuilder();
		
		this.cells = new ArrayList<List<Cell>>();
        for (int row = 0; row < this.height; row++) {
			List<Cell> mapRow = new ArrayList<Cell>();
			for (int col = 0; col < this.width; col++) {
				Node node = nodes.item(row + col);
				Cell createdCell = cellBuilder.createCell(node);
				mapRow.add(createdCell);
			}
			this.cells.add(mapRow);
        }
    }

    private void loadInitialLabyrinthConfigurations(String XMLpath) throws NumberFormatException, AttributeNotFoundException {
        Node headerNode = XMLReader.getNodeByName(XMLpath, XMLConstants.LABYRINTH).item(0);
        this.width = XMLReader.getIntAttributeValue(headerNode, XMLConstants.WIDTH);
		this.height = XMLReader.getIntAttributeValue(headerNode, XMLConstants.HEIGTH);
		createPacman(headerNode, XMLpath);
		this.ghostStart = this.loadStageElementPosition(headerNode, XMLpath, XMLConstants.GHOST_START);
    }

    private void createPacman(Node headerNode, String XMLpath) throws NumberFormatException, AttributeNotFoundException {
        this.pacmanStart = this.loadStageElementPosition(headerNode, XMLpath, XMLConstants.PACMAN_START);
        this.pacman = new Pacman(this, this.pacmanStart);
    }
	
	private Position loadStageElementPosition(Node headerNode, String XMLpath, String elementTag) throws NumberFormatException, AttributeNotFoundException {
        int elementId = new Integer(XMLReader.getAttributeValue(headerNode, elementTag));
        NodeList nodes = XMLReader.getNodeByName(XMLpath, XMLConstants.NODE);
        Node elementNode = XMLReader.getNodeById(nodes, elementId);
        return XMLReader.getNodePosition(elementNode);
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
    public Pacman getPacman() {
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
    public void placePacmanAtHome(Pacman givenPacman) {
		this.forcePlaceElement(this.pacmanStart, givenPacman);
    }

	@Override
    public boolean pacmanIsInArea(Area area) {
        return this.pacman.isInArea(area);
    }
	
}
