package com.tdd.model.helpers;

import com.tdd.model.stageAbstractions.Position;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.management.AttributeNotFoundException;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 *
 */
public class LabyrinthLoader {

    private final Node headerNode;
    private final NodeList nodes;

    private static boolean initialized = false;
    private static LabyrinthLoader labyrinthLoader = null;

    private LabyrinthLoader(String xmlPath) {
        this.headerNode = XMLReader.getNodeByName(xmlPath, XMLConstants.LABYRINTH).item(0);
        this.nodes = XMLReader.getNodeByName(xmlPath, XMLConstants.NODE);
    }

    /**
     *
     * @param xmlPath
     * @return
     */
    public static LabyrinthLoader getLabyrinthLoader(String xmlPath) {
        if (!LabyrinthLoader.initialized) {
            LabyrinthLoader.labyrinthLoader = new LabyrinthLoader(xmlPath);
            LabyrinthLoader.initialized = true;
        }
        return LabyrinthLoader.labyrinthLoader;
    }

    /**
     *
     * @return @throws AttributeNotFoundException
     */
    public Integer getLabyrinthWidth() throws AttributeNotFoundException {
        return XMLReader.getIntAttributeValue(this.headerNode, XMLConstants.WIDTH);
    }

    /**
     *
     * @return @throws AttributeNotFoundException
     */
    public Integer getLabyrinthHeigth() throws AttributeNotFoundException {
        return XMLReader.getIntAttributeValue(this.headerNode, XMLConstants.HEIGHT);
    }

    /**
     *
     * @return @throws AttributeNotFoundException
     */
    public Position getPacmanStartPosition() throws AttributeNotFoundException {
        Position pacmanPosition = null;
        int pacmanNodeId = XMLReader.getIntAttributeValue(this.headerNode, XMLConstants.PACMAN_START);
        try {
            pacmanPosition = this.loadStageElementPosition(pacmanNodeId);
        } catch (NumberFormatException ex) {
            Logger.getLogger(LabyrinthLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return pacmanPosition;
    }

    /**
     *
     * @return @throws AttributeNotFoundException
     */
    public Position getGhostStartPosition() throws AttributeNotFoundException {
        Position ghostPosition = null;
        int ghostNodeId = XMLReader.getIntAttributeValue(this.headerNode, XMLConstants.GHOST_START);
        try {
            ghostPosition = this.loadStageElementPosition(ghostNodeId);
        } catch (NumberFormatException ex) {
            Logger.getLogger(LabyrinthLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return ghostPosition;
    }

    /**
     *
     * @return
     */
    public NodeList getNodes() {
        return this.nodes;
    }

    /**
     *
     * @param elementId
     * @return
     * @throws NumberFormatException
     * @throws AttributeNotFoundException
     */
    private Position loadStageElementPosition(int elementId) throws NumberFormatException, AttributeNotFoundException {
        Node elementNode = XMLReader.getNodeById(this.nodes, elementId);
        return XMLReader.getNodePosition(elementNode);
    }
}
