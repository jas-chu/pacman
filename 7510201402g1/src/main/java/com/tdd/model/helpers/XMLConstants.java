package com.tdd.model.helpers;

import java.util.HashMap;
import java.util.Map;

/**
 *
 * Content constant xml nodes and attributes
 */
public abstract class XMLConstants {

    /* TRANSLATION KEYS */
    public static final String LABYRINTH = "labyrinth";
    public static final String NODE = "node";
    public static final String WIDTH = "width";
    public static final String HEIGHT = "height";
    public static final String GHOST_START = "ghostStart";
    public static final String PACMAN_START = "pacmanStart";
    public static final String ROW = "row";
    public static final String COLUMN = "column";
    public static final String CONTENT = "content";
    public static final String ID = "id";
    public static final String DIRECTION = "direccion";

    /* DIRECTION VALUES */
    public static final String DIRECTION_UP = "up";
    public static final String DIRECTION_DOWN = "down";
    public static final String DIRECTION_LEFT = "left";
    public static final String DIRECTION_RIGHT = "right";

    protected Map<String, String> translationDictionary;
    protected Map<String, String> invertedDirectionValuesDictionary;

    public XMLConstants() {
        this.translationDictionary = new HashMap<String, String>();
        this.invertedDirectionValuesDictionary = new HashMap<String, String>();
    }

    public String getConstantTranslation(String key) {
        return this.searchTranslation(this.translationDictionary, key);
    }

    public String getDirectionValueTranslation(String key) {
        return this.searchTranslation(this.invertedDirectionValuesDictionary, key);
    }

    /**
     * Searches for translation, if it doesn't exist, returns default value.
     *
     * @param key
     * @return
     */
    private String searchTranslation(Map<String, String> dictionary, String key) {
        if (dictionary.containsKey(key)) {
            return dictionary.get(key);
        } else {
            return key;
        }
    }

}
