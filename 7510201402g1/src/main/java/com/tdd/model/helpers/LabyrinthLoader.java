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

    public LabyrinthLoader(String xmlPath) {
        this.headerNode = XMLReader.getNodeByName(xmlPath, XMLConstants.LABYRINTH).item(0);
        this.nodes = XMLReader.getNodeByName(xmlPath, XMLConstants.NODE);
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
    public Integer getLabyrinthHeight() throws AttributeNotFoundException {
        return XMLReader.getIntAttributeValue(this.headerNode, XMLConstants.HEIGHT);
    }

    /**
     *
     * @return @throws AttributeNotFoundException
     */
    public Position getPacmanStartPosition() throws AttributeNotFoundException {
        return getCharacterStartPosition(XMLConstants.PACMAN_START);
    }

    /**
     *
     * @return @throws AttributeNotFoundException
     */
    public Position getGhostStartPosition() throws AttributeNotFoundException {
        return getCharacterStartPosition(XMLConstants.GHOST_START);
    }
	
	/**
     *
	 * @param characterAttributeName
     * @return @throws AttributeNotFoundException
     */
    public Position getCharacterStartPosition(String characterAttributeName) throws AttributeNotFoundException {
        Position characterPosition = null;
        int characterNodeId = XMLReader.getIntAttributeValue(this.headerNode, characterAttributeName);
        try {
            characterPosition = this.loadStageElementPosition(characterNodeId);
        } catch (NumberFormatException ex) {
            Logger.getLogger(LabyrinthLoader.class.getName()).log(Level.SEVERE, null, ex);
        }
        return characterPosition;
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

    /**
     *
     * @return @throws AttributeNotFoundException
     */
    public Integer getNodeWidth() throws AttributeNotFoundException {
        return XMLReader.getIntAttributeValue(this.headerNode, XMLConstants.NODE_WIDTH);
    }

    /**
     *
     * @return @throws AttributeNotFoundException
     */
    public Integer getNodeHeight() throws AttributeNotFoundException {
        return XMLReader.getIntAttributeValue(this.headerNode, XMLConstants.NODE_HEIGHT);
    }
}
