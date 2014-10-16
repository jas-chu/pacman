package com.tdd.model.helpers;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Content constant xml nodes and attributes
 */
public abstract class XMLConstants {

    /* TRANSLATION KEYS */
	public static final String TICK = "Tick";
    public static final String LABYRINTH = "labyrinth";
    public static final String NODE = "node";
    public static final String WIDTH = "width";
    public static final String HEIGHT = "height";
    public static final String GHOST_START = "ghostStart";
    public static final String PACMAN_START = "pacmanStart";
    public static final String ROW = "row";
    public static final String COLUMN = "column";
    public static final String ID = "id";
    public static final String GAME = "game";
    public static final String PACMAN_POSITION = "pacmanPosition";
    public static final String SENSE = "sense";
    public static final String PERSONALITY = "personality";
    public static final String STATUS = "status";
    public static final String GHOST = "ghost";
	public static final String PACMAN = "pacman";
    public static final String SCORE = "score";
    public static final String END_GAME = "endGame";
    public static final String NODE_WIDTH = "nodeWidth";
    public static final String NODE_HEIGHT = "nodeHeight";

    /* DIRECTION VALUES */
	public static final String DIRECTION = "direccion";
    public static final String DIRECTION_UP = "up";
    public static final String DIRECTION_DOWN = "down";
    public static final String DIRECTION_LEFT = "left";
    public static final String DIRECTION_RIGHT = "right";
    
    /* STRATEGY VALUES */
    public static final String LAZY_STRATEGY = "lazy";
    public static final String SILLY_STRATEGY = "silly";
    public static final String STRATEGY_NORMAL_SEARCHER = "normalSearcher";
    public static final String STRATEGY_TEMPERAMENT_SEARCHER = "temperamentSearcher";    

    /* CONTENT VALUES */
	public static final String CONTENT = "content";
    public static final String DOT = "dot";
    public static final String BIG_DOT = "bigDot";

    protected Map<String, String> translationDictionary;
    protected Map<String, String> invertedDirectionValuesDictionary;

    public XMLConstants() {
        this.translationDictionary = new HashMap<String, String>();
        this.invertedDirectionValuesDictionary = new HashMap<String, String>();
    }

	/**
	 * Translates key from default to specific language.
	 * @param key
	 * @return
	 */
	public String getConstantTranslation(String key) {
        return this.searchTranslation(this.translationDictionary, key);
    }
	
	/**
	 * Translates key representing a direction value from specific to default language.
	 * @param key
	 * @return
	 */
	public String getInvertedDirectionValueTranslation(String key) {
        return this.searchTranslation(this.invertedDirectionValuesDictionary, key);
    }

    /**
     * Searches for translation, if it doesn't exist, returns default value.
     * @param key
     * @return translation
     */
    private String searchTranslation(Map<String, String> dictionary, String key) {
        if (dictionary.containsKey(key)) {
            return dictionary.get(key);
        } else {
            return key;
        }
    }
	
}