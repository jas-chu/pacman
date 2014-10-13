package com.tdd.model.helpers;

import com.tdd.model.stageAbstractions.Position;
import javax.management.AttributeNotFoundException;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

/**
 *
 *
 */
public class GameCharactersLoader {

    private final Node game;
    private final NodeList ghosts;

    private static boolean initialized = false;
    private static GameCharactersLoader charactersLoader = null;

    /**
     *
     * @param xmlPath
     */
    private GameCharactersLoader(String xmlPath) {
        this.game = XMLReader.getNodeByName(xmlPath, XMLConstants.GAME).item(0);
        this.ghosts = XMLReader.getNodeByName(xmlPath, XMLConstants.GHOST);
    }

    /**
     *
     * @param xmlPath
     * @return
     */
    public static GameCharactersLoader getCharactersLoader(String xmlPath) {
        if (!GameCharactersLoader.initialized) {
            GameCharactersLoader.charactersLoader = new GameCharactersLoader(xmlPath);
            GameCharactersLoader.initialized = true;
        }
        return GameCharactersLoader.charactersLoader;
    }

    /**
     *
     * @return @throws AttributeNotFoundException
     */
    public Position getPacmanPosition() throws AttributeNotFoundException {

        int row = XMLReader.getIntAttributeValue(this.game, XMLConstants.ROW);
        int column = XMLReader.getIntAttributeValue(this.game, XMLConstants.COLUMN);
        return new Position(column, row);
    }

    /**
     *
     * @return @throws AttributeNotFoundException
     */
    public String getPacmanSense() throws AttributeNotFoundException {
        return XMLReader.getAttributeValue(this.game, XMLConstants.SENSE);
    }

    /**
     *
     * @return @throws AttributeNotFoundException
     */
    public int getScore() throws AttributeNotFoundException {
        return XMLReader.getIntAttributeValue(this.game, XMLConstants.SCORE);
    }

    /**
     *
     * @return @throws AttributeNotFoundException
     */
    public boolean isEndGame() throws AttributeNotFoundException {
        return XMLReader.getBooleanAttributeValue(this.game, XMLConstants.END_GAME);
    }

    /**
     * 
     * @return lista de nodos con data de fantasma
     */
    public NodeList getGhostNodes(){
        return this.ghosts;
    }
}
