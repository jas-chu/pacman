package com.tdd.model.helpers;

import com.tdd.model.stage.Labyrinth;
import com.tdd.model.stageAbstractions.Cell;
import java.util.HashMap;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.xml.transform.TransformerException;

/**
 *
 *
 */
public class LabyrinthSerializer {
	
    private String path;
	private Labyrinth labyrinth;

    public LabyrinthSerializer(Labyrinth labyrinth) {
        this.path = "";
        this.labyrinth = labyrinth;
    }

    /**
     *
     * @return
     */
    public String getPath() {
        return this.path;
    }

    /**
     *
     * @param givenPath
     */
    public void serialize(String givenPath) {
        this.path = givenPath;
        XMLWriter writer = new XMLWriter(this.path);
        writer.createRoot(XMLConstants.LABYRINTH, this.getLabyrinthAttributes());
        this.addNodes(writer, labyrinth.getCells());
        try {
            writer.write();
        } catch (TransformerException ex) {
            Logger.getLogger(LabyrinthSerializer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    /**
     * 
     * @param writer
     * @param cells 
     */
    private void addNodes(XMLWriter writer, List<List<Cell>> cells) {
        for (List<Cell> cellRow : cells) {
            for (Cell cell : cellRow) {
                writer.addElementToRoot(XMLConstants.NODE, this.getCellAttributes(cell));
            }
        }
    }

    /**
     *
     * @return
     */
    private HashMap<String, String> getLabyrinthAttributes() {

        HashMap<String, String> attributes = new HashMap<>();
        attributes.put(XMLConstants.WIDTH, labyrinth.getHeight().toString());
        attributes.put(XMLConstants.HEIGHT, labyrinth.getHeight().toString());
        attributes.put(XMLConstants.PACMAN_START, labyrinth.getPacmanStart().toString());
        attributes.put(XMLConstants.GHOST_START, labyrinth.getGhostStart().toString());
        attributes.put(XMLConstants.NODE_WIDTH, labyrinth.getNodeWidth().toString());
        attributes.put(XMLConstants.NODE_HEIGHT, labyrinth.getNodeHeight().toString());
        return attributes;

    }
    /**
     * 
     * @param cell
     * @return 
     */
    private HashMap<String, String> getCellAttributes(Cell cell) {
        HashMap<String, String> attributes = new HashMap<>();
        attributes.put(XMLConstants.ID, cell.getId().toString());
        attributes.put(XMLConstants.ROW, cell.getRow().toString());
        attributes.put(XMLConstants.COLUMN, cell.getColumn().toString());
        attributes.put(XMLConstants.CONTENT, cell.getContent());
        attributes.put(XMLConstants.DIRECTION_LEFT, cell.getNeighbour(XMLConstants.DIRECTION_LEFT));
        attributes.put(XMLConstants.DIRECTION_RIGHT, cell.getNeighbour(XMLConstants.DIRECTION_RIGHT));
        attributes.put(XMLConstants.DIRECTION_UP, cell.getNeighbour(XMLConstants.DIRECTION_UP));
        attributes.put(XMLConstants.DIRECTION_DOWN, cell.getNeighbour(XMLConstants.DIRECTION_DOWN));
        return attributes;

    }
}
