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
    /**
     * 
     */
    private Node headerNode;
    /**
     * 
     */
    private NodeList nodes;
    /**
     * 
     */
    private static boolean initialized = false;
    /**
     * 
     */
    private static LabyrinthLoader labyrinthLoader = null;

    /**
     *
     */
    private LabyrinthLoader() {
        LabyrinthLoader.initialized = true;
    }

    /**
     *
     * @param xmlPath
     * @return
     */
    static public LabyrinthLoader getLabyrinthLoader(String xmlPath) {
        if (!LabyrinthLoader.initialized) {
            labyrinthLoader = new LabyrinthLoader();
            labyrinthLoader.headerNode = XMLReader.getNodeByName(xmlPath, XMLConstants.LABYRINTH).item(0);
            labyrinthLoader.nodes = XMLReader.getNodeByName(xmlPath, XMLConstants.NODE);
        }
        return labyrinthLoader;
    }

    /**
     *
     * @return @throws AttributeNotFoundException
     */
    public Integer getLabyrinthWidth() throws AttributeNotFoundException {
        return XMLReader.getIntAttributeValue(labyrinthLoader.headerNode, XMLConstants.WIDTH);
    }

    /**
     *
     * @return @throws AttributeNotFoundException
     */
    public Integer getLabyrinthHeigth() throws AttributeNotFoundException {
        return XMLReader.getIntAttributeValue(labyrinthLoader.headerNode, XMLConstants.HEIGTH);
    }

    /**
     *
     * @return @throws AttributeNotFoundException
     */
    public Position getPacmanStartPosition() throws AttributeNotFoundException {
        Position pacmanPosition = null;
        int pacmanNodeId = XMLReader.getIntAttributeValue(labyrinthLoader.headerNode, XMLConstants.PACMAN_START);
        try {
            pacmanPosition = labyrinthLoader.loadStageElementPosition(pacmanNodeId);
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
        int ghostNodeId = XMLReader.getIntAttributeValue(labyrinthLoader.headerNode, XMLConstants.GHOST_START);
        try {
            ghostPosition = labyrinthLoader.loadStageElementPosition(ghostNodeId);
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
        return labyrinthLoader.nodes;
    }

    /**
     *
     * @param elementId
     * @return
     * @throws NumberFormatException
     * @throws AttributeNotFoundException
     */
    private Position loadStageElementPosition(int elementId) throws NumberFormatException, AttributeNotFoundException {
        Node elementNode = XMLReader.getNodeById(labyrinthLoader.nodes, elementId);
        return XMLReader.getNodePosition(elementNode);
    }
}
