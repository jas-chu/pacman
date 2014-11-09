package com.tdd.model.helpers;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Content constant xml nodes and attributes
 */
public abstract class XMLConstants {

    /* TRANSLATION KEYS */
	public static final String GAME = "game";
	public static final String LEVEL = "level";
	public static final String LEVEL_TYPE = "type";
	public static final String KEYBOARD_LEVEL = "keyboardLevel";
	public static final String NO_PACMAN_LEVEL = "noPacmanLevel";
	public static final String XML_LEVEL = "xmlLevel";
	public static final String STAGE = "stage";
	public static final String CHARACTERS = "characters";
	public static final String SAVE_PATH = "saveTo";
	public static final String ANGER_CYCLES = "angerCycles";
	public static final String VALUE = "value";
	public static final String DEAD_CYCLES = "deadCycles";
	public static final String PREY_CYCLES = "preyCycles";
	public static final String GHOST_VISION = "ghostVision";
	public static final String INCREMENTAL_VISION = "incrementalVision";
	public static final String TICKS_TO_RUN = "ticksToRun";
	
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
    public static final String DIRECTION = "direction";
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
	public static final String FRUIT = "fruit";

    /* STATUS VALUES */
    public static final String HUNTER = "hunter";
    public static final String DEAD = "dead";
    public static final String PREY = "prey";

    /* DICTIONARIES */
    protected Map<String, String> translationDictionary;
	protected Map<String, String> invertedLevelTypeValuesDictionary;
    protected Map<String, String> invertedDirectionValuesDictionary;
    protected Map<String, String> invertedStrategyValuesDictionary;
    protected Map<String, String> invertedStatusValuesDictionary;
	protected Map<String, String> invertedItemValuesDictionary;

    public XMLConstants() {
        this.translationDictionary = new HashMap<String, String>();
		this.invertedLevelTypeValuesDictionary = new HashMap<String, String>();
        this.invertedDirectionValuesDictionary = new HashMap<String, String>();
        this.invertedStrategyValuesDictionary = new HashMap<String, String>();
        this.invertedStatusValuesDictionary = new HashMap<String, String>();
		this.invertedItemValuesDictionary = new HashMap<String, String>();
    }

    /**
     * Translates key from default to specific language.
     *
     * @param key
     * @return
     */
    public String getConstantTranslation(String key) {
        return this.searchTranslation(this.translationDictionary, key);
    }
	
	/**
     * Translates key representing a level type value from specific to default
     * language.
     *
     * @param key
     * @return
     */
    public String getInvertedLevelTypeValueTranslation(String key) {
        return this.searchTranslation(this.invertedLevelTypeValuesDictionary, key);
    }
	
    /**
     * Translates key representing a direction value from specific to default
     * language.
     *
     * @param key
     * @return
     */
    public String getInvertedDirectionValueTranslation(String key) {
        return this.searchTranslation(this.invertedDirectionValuesDictionary, key);
    }
    
    /**
     * Translates key representing a status value from specific to default
     * language.
     * @param key
     * @return 
     */
    public String getInvertedStatusValueTranslation(String key) {
        return this.searchTranslation(this.invertedStatusValuesDictionary, key);
    }
    
    /**
     * Translates key representing a strategy value from specific to default
     * language.
     *
     * @param key
     * @return
     */
    public String getInvertedStrategyValueTranslation(String key) {
        return this.searchTranslation(this.invertedStrategyValuesDictionary, key);
    }
	
	/**
     * Translates key representing a item value from specific to default
     * language.
     *
     * @param key
     * @return
     */
    public String getInvertedItemValueTranslation(String key) {
        return this.searchTranslation(this.invertedItemValuesDictionary, key);
    }

    /**
     * Searches for translation, if it doesn't exist, returns default value.
     *
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
