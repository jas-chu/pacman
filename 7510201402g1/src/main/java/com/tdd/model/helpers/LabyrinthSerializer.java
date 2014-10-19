package com.tdd.model.helpers;

import com.tdd.model.stageAbstractions.Cell;
import com.tdd.model.stageAbstractions.Stage;
import java.io.File;
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

    private XMLConstants gameConstants;
    private String rootPath;
    private Stage stage;

    public LabyrinthSerializer(Stage givenStage, String givenRootPath, XMLConstants constants) {
        this.gameConstants = constants;
        this.rootPath = givenRootPath;
        this.stage = givenStage;
    }

    /**
     *
     * @return
     */
    public String getPath() {
        return this.rootPath;
    }

    public void serialize(long cycle) {
        String labyrinthName = this.gameConstants.getConstantTranslation(XMLConstants.LABYRINTH);
        String nameSuffix = this.gameConstants.getConstantTranslation(XMLConstants.TICK);
        String path = rootPath + File.separator + labyrinthName + nameSuffix + cycle + ".xml";
        XMLWriter writer = new XMLWriter(path);
        writer.createRoot(XMLConstants.LABYRINTH, this.getLabyrinthAttributes());
        this.addNodes(writer, stage.getCells());
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
        XMLWriter.addIntAttributeToCustomMap(attributes, XMLConstants.WIDTH, stage.getWidth(), 2);
        XMLWriter.addIntAttributeToCustomMap(attributes, XMLConstants.HEIGHT, stage.getHeight(), 2);
        XMLWriter.addAttributeToCustomMap(attributes, XMLConstants.PACMAN_START, stage.getPacmanStart().toString());
        XMLWriter.addAttributeToCustomMap(attributes, XMLConstants.GHOST_START, stage.getGhostStart().toString());
        XMLWriter.addIntAttributeToCustomMap(attributes, XMLConstants.NODE_WIDTH, stage.getNodeWidth(), 2);
        XMLWriter.addIntAttributeToCustomMap(attributes, XMLConstants.NODE_HEIGHT, stage.getNodeHeight(), 2);
        return attributes;
    }

    /**
     *
     * @param cell
     * @return
     */
    private HashMap<String, String> getCellAttributes(Cell cell) {
        HashMap<String, String> attributes = new HashMap<>();
        XMLWriter.addIntAttributeToCustomMap(attributes, XMLConstants.ID, cell.getId(), 4);
        XMLWriter.addIntAttributeToCustomMap(attributes, XMLConstants.ROW, cell.getRow(), 2);
        XMLWriter.addIntAttributeToCustomMap(attributes, XMLConstants.COLUMN, cell.getColumn(), 2);
        XMLWriter.addAttributeToCustomMapWithValueTranslation(attributes, XMLConstants.CONTENT, cell.getContent());
        XMLWriter.addAttributeToCustomMap(attributes, XMLConstants.DIRECTION_LEFT, cell.getNeighbour(XMLConstants.DIRECTION_LEFT));
        XMLWriter.addAttributeToCustomMap(attributes, XMLConstants.DIRECTION_RIGHT, cell.getNeighbour(XMLConstants.DIRECTION_RIGHT));
        XMLWriter.addAttributeToCustomMap(attributes, XMLConstants.DIRECTION_UP, cell.getNeighbour(XMLConstants.DIRECTION_UP));
        XMLWriter.addAttributeToCustomMap(attributes, XMLConstants.DIRECTION_DOWN, cell.getNeighbour(XMLConstants.DIRECTION_DOWN));
        return attributes;
    }
}
