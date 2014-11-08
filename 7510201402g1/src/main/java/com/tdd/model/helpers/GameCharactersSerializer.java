package com.tdd.model.helpers;

import com.tdd.application.gameAbstractions.GameLevel;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.Position;
import com.tdd.model.stageAbstractions.Protagonist;
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
public class GameCharactersSerializer {

    private final XMLConstants gameConstants;
    private final String filePath;
    private final GameLevel game;

    public GameCharactersSerializer(GameLevel givenGame, String filePath, XMLConstants constants) {
        this.gameConstants = constants;
        this.filePath = filePath;
        this.game = givenGame;
    }

    /**
     *
     * @return
     */
    public String getPath() {
        return this.filePath;
    }

    /**
     *
     * @param cycle
     */
    public void serialize(long cycle) {
        String charactersName = this.gameConstants.getConstantTranslation(XMLConstants.CHARACTERS);
        String nameSuffix = this.gameConstants.getConstantTranslation(XMLConstants.TICK);
        String path = this.filePath + File.separator + charactersName + nameSuffix + cycle + ".xml";
        XMLWriter writer = new XMLWriter(path);
        writer.createRoot(XMLConstants.GAME, this.getGameAttributes());
        this.addNodes(writer, game.getEnemies());
		try {
            writer.write();
        } catch (TransformerException ex) {
            Logger.getLogger(LabyrinthSerializer.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     *
     * @return
     */
    private HashMap<String, String> getGameAttributes() {
        HashMap<String, String> attributes = new HashMap<>();
        Protagonist protagonist = game.getProtagonist();
		if (protagonist != null) {
			Position position = protagonist.getPosition();
			String sense = protagonist.getSense().toString();
			Integer score = protagonist.getScore();
			XMLWriter.addAttributeToCustomMap(attributes, XMLConstants.PACMAN_START, position.toString());
			XMLWriter.addIntAttributeToCustomMap(attributes, XMLConstants.ROW, position.getY(), 2);
			XMLWriter.addIntAttributeToCustomMap(attributes, XMLConstants.COLUMN, position.getX(), 2);
			XMLWriter.addAttributeToCustomMap(attributes, XMLConstants.SENSE, sense);
			XMLWriter.addIntAttributeToCustomMap(attributes, XMLConstants.SCORE, score, 2);
		}
		Boolean endGame = game.isEndOfLevel();
		XMLWriter.addBooleanAttributeToCustomMap(attributes, XMLConstants.END_GAME, endGame);
        return attributes;
    }

    /**
     *
     * @param writer
     * @param enemies
     */
    private void addNodes(XMLWriter writer, List<Enemy> enemies) {
        for (Enemy enemy : enemies) {
             writer.addElementToRoot(XMLConstants.GHOST, this.getEnemyAttributes(enemy));
        }

    }

    /**
     *
     * @param enemy
     * @return
     */
    private HashMap<String, String> getEnemyAttributes(Enemy enemy) {
        HashMap<String, String> attributes = new HashMap<>();
        Position position = enemy.getPosition();
        String sense = enemy.getSense().toString();
        String status = enemy.getState().toString();
        String personality = enemy.getStrategy().toString();
        XMLWriter.addIntAttributeToCustomMap(attributes, XMLConstants.ID, enemy.getId(), 1);
        XMLWriter.addAttributeToCustomMap(attributes, XMLConstants.NODE, position.toString());
        XMLWriter.addIntAttributeToCustomMap(attributes, XMLConstants.ROW, position.getY(), 2);
        XMLWriter.addIntAttributeToCustomMap(attributes, XMLConstants.COLUMN, position.getX(), 2);
        XMLWriter.addAttributeToCustomMapWithValueTranslation(attributes, XMLConstants.SENSE, sense);
        XMLWriter.addAttributeToCustomMapWithValueTranslation(attributes, XMLConstants.PERSONALITY, personality);
        XMLWriter.addAttributeToCustomMapWithValueTranslation(attributes, XMLConstants.STATUS, status);
        return attributes;
    }

}
