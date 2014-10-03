package com.tdd.model.stage;

import com.tdd.helpers.XMLReader;
import com.tdd.model.cell.cellFactory.CellFactorySearcher;
import com.tdd.model.configuration.Configuration;
import com.tdd.model.exceptions.BlockedCellException;
import com.tdd.model.ghost.Ghost;
import com.tdd.model.stageAbstractions.Cell;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.Item;
import com.tdd.model.stageAbstractions.Position;
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

    private ArrayList<Item> items;
    private ArrayList<Enemy> enemies;
    private Pacman pacman;
    private int width;
    private int heigth;
    private int pacmanStart;
    private int ghostStart;
    private List<Cell> cells;

    public Labyrinth(String XMLpath) {
        Configuration conf = Configuration.getConfiguration();
        loadInitialLabyrinthConfigurations(conf);
        loadCells(conf);
    }

    private void loadCells(Configuration conf) {
        NodeList nodes = XMLReader.getNodeByName(conf.getLabyrinthFilePath(), "nodo");
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
            cells.add(createCell(node));
        }
    }

    private Cell createCell(Node node) {
        
        try {
            String nodeContent = XMLReader.getAttributeValue(node, "contiene");
        } catch (AttributeNotFoundException ex) {
            Logger.getLogger(Labyrinth.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        CellFactorySearcher cellFactory = new CellFactorySearcher();
        return cellFactory.getFactory(CellFactorySearcher.CellName.CLEAR).getCell();
    }

    private void loadInitialLabyrinthConfigurations(Configuration conf) throws NumberFormatException {
        Node headerNode = XMLReader.getNodeByName(conf.getLabyrinthFilePath(), "laberinto").item(0);
        try {
            this.width = new Integer(XMLReader.getAttributeValue(headerNode, "ancho"));
            this.heigth = new Integer(XMLReader.getAttributeValue(headerNode, "alto"));
            createPacman(headerNode, conf);
            this.ghostStart = new Integer(XMLReader.getAttributeValue(headerNode, "inicioFantasmas"));
        } catch (AttributeNotFoundException ex) {
            Logger.getLogger(Labyrinth.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    private void createPacman(Node headerNode, Configuration conf) throws NumberFormatException, AttributeNotFoundException {
        this.pacmanStart = new Integer(XMLReader.getAttributeValue(headerNode, "inicioPacman"));
        NodeList nodes = XMLReader.getNodeByName(conf.getLabyrinthFilePath(), "nodo");
        Node nodePacmanStart = XMLReader.getNodeById(nodes, this.pacmanStart);
        int pacmanX = Integer.getInteger(XMLReader.getAttributeValue(nodePacmanStart, "fila"));
        int pacmanY = Integer.getInteger(XMLReader.getAttributeValue(nodePacmanStart, "columna"));
        Position positionPacman = new Position(pacmanX, pacmanY);
        this.pacman = new Pacman(this, positionPacman);
    }

    @Override
    public ArrayList<Item> getItems() {
        return items;
    }

    @Override
    public ArrayList<Enemy> getEnemies() {
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

    private void testPlaceElement(Position position) throws BlockedCellException {
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void placeElement(Position position, StageElement element) throws BlockedCellException {
        this.testPlaceElement(position);
        throw new UnsupportedOperationException("Not supported yet.");
    }

    @Override
    public void placeEnemyAtHome(Enemy givenEnemy) {
        throw new UnsupportedOperationException("Not supported yet.");
    }

}
