package com.tdd.model.stage;

import com.tdd.helpers.XMLReader;
import com.tdd.model.cell.cellFactory.CellFactory;
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
        loadLabyrinthConfigurations(conf);
        loadCells(conf);
    }

    private void loadCells(Configuration conf) {
        NodeList nodes = XMLReader.getNodeByName(conf.getLabyrinthFilePath(), "nodo");
        for (int i = 0; i < nodes.getLength(); i++) {
            Node node = nodes.item(i);
//            cells.add();
        }
    }

    private void loadLabyrinthConfigurations(Configuration conf) throws NumberFormatException {
        Node headerNode = XMLReader.getNodeByName(conf.getLabyrinthFilePath(), "laberinto").item(0);
        try {
            this.width = new Integer(XMLReader.getAttributeValue(headerNode, "ancho"));
            this.heigth = new Integer(XMLReader.getAttributeValue(headerNode, "alto"));
            this.pacmanStart = new Integer(XMLReader.getAttributeValue(headerNode, "inicioPacman"));
            this.ghostStart = new Integer(XMLReader.getAttributeValue(headerNode, "inicioFantasmas"));
        } catch (AttributeNotFoundException ex) {
            Logger.getLogger(Labyrinth.class.getName()).log(Level.SEVERE, null, ex);
        }


        /* TODO:
         Recorrer el nodo y por cada elemento llamar a una instancia factory
         para que me cree la entidad que corresponda y lo agregue a la lista
         adecuada.
         */
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
