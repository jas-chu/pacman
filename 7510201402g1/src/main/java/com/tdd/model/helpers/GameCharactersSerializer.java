package com.tdd.model.helpers;

import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.Position;
import com.tdd.model.stageAbstractions.Protagonist;
import com.tdd.model.stageAbstractions.Stage;
import java.io.File;
import java.util.HashMap;
import java.util.List;

/**
 *
 *
 */
public class GameCharactersSerializer {

    private final XMLConstants gameConstants;
    private final String filePath;
    private final Stage stage;

    public GameCharactersSerializer(Stage stage, String filePath, XMLConstants constants) {
        this.gameConstants = constants;
        this.filePath = filePath;
        this.stage = stage;
    }

    /**
     *
     * @return
     */
    public String getPath() {
        return this.filePath;
    }

    public void serialize(long cycle) {
        String charactersName = this.gameConstants.getConstantTranslation(XMLConstants.CHARACTERS);
        String nameSuffix = this.gameConstants.getConstantTranslation(XMLConstants.TICK);
        String path = this.filePath + File.separator + charactersName + nameSuffix + cycle + ".xml";
        XMLWriter writer = new XMLWriter(path);
        writer.createRoot(XMLConstants.GAME, this.getGameAttributes());
        this.addNodes(writer, stage.getEnemies());

    }

    private HashMap<String, String> getGameAttributes() {
        HashMap<String, String> attributes = new HashMap<>();
        //posicionPacman="0412" fila="04" columna="12" sentido="arriba" puntaje="80" finJuego="false"
        Protagonist protagonist = stage.getProtagonist();
        Position position = protagonist.getPosition();
        String sense = protagonist.getSense().toString();
        Integer score = null;//stage.getScore();
        Boolean endGame = false;//stage.getStatusGame();
        XMLWriter.addAttributeToCustomMap(attributes, XMLConstants.PACMAN_START, position.toString());
        XMLWriter.addIntAttributeToCustomMap(attributes, XMLConstants.ROW, position.getY(), 2);
        XMLWriter.addIntAttributeToCustomMap(attributes, XMLConstants.COLUMN, position.getX(), 2);
        XMLWriter.addAttributeToCustomMap(attributes, XMLConstants.SENSE, sense);
        XMLWriter.addIntAttributeToCustomMap(attributes, XMLConstants.SCORE, score, 2);
        XMLWriter.addBooleanAttributeToCustomMap(attributes, XMLConstants.END_GAME, endGame);
        return attributes;
    }

    private void addNodes(XMLWriter writer, List<Enemy> enemies) {
        for (Enemy enemy : enemies) {
            writer.addElementToRoot(XMLConstants.GHOST, this.getEnemyAttributes(enemy));
        }

    }

    private HashMap<String, String> getEnemyAttributes(Enemy enemy) {
        HashMap<String, String> attributes = new HashMap<>();
        Position position = enemy.getPosition();
        String sense = enemy.getSense().toString();
        String personality = "";
        String status = "";
        //<fantasma id="1" nodo="1010" fila="10" columna="10" sentido="arriba" personalidad="zonzo" estado="cazador" />
        XMLWriter.addIntAttributeToCustomMap(attributes, XMLConstants.ROW, enemy.getId(), 1);
        XMLWriter.addAttributeToCustomMap(attributes, XMLConstants.NODE, position.toString());
        XMLWriter.addIntAttributeToCustomMap(attributes, XMLConstants.ROW, position.getY(), 2);
        XMLWriter.addIntAttributeToCustomMap(attributes, XMLConstants.COLUMN, position.getX(), 2);
        XMLWriter.addAttributeToCustomMap(attributes, XMLConstants.SENSE, sense);
        XMLWriter.addAttributeToCustomMap(attributes, XMLConstants.PERSONALITY, personality);
        XMLWriter.addAttributeToCustomMap(attributes, XMLConstants.STATUS, status);
        return attributes;
    }

}
