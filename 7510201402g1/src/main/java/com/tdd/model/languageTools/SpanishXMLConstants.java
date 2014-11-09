package com.tdd.model.languageTools;

import com.tdd.model.helpers.XMLConstants;

public class SpanishXMLConstants extends XMLConstants {

    public SpanishXMLConstants() {
        super();
        this.fillTranslationDictionary();
		this.fillLevelTypeValuesDictionary();
        this.fillDirectionValuesDictionary();
        this.fillStrategyValuesDictionary();
        this.fillStatusValuesDictionary();
		this.fillItemValuesDictionary();
    }

    private void fillTranslationDictionary() {
        this.translationDictionary.put(TICK, "Tick");
        this.translationDictionary.put(LABYRINTH, "laberinto");
        this.translationDictionary.put(CHARACTERS, "personajes");
        this.translationDictionary.put(NODE, "nodo");
        this.translationDictionary.put(WIDTH, "ancho");
        this.translationDictionary.put(HEIGHT, "alto");
        this.translationDictionary.put(GHOST_START, "inicioFantasmas");
        this.translationDictionary.put(PACMAN_START, "inicioPacman");
        this.translationDictionary.put(ROW, "fila");
        this.translationDictionary.put(COLUMN, "columna");
        this.translationDictionary.put(ID, "id");
        this.translationDictionary.put(GAME, "juego");
		
		this.translationDictionary.put(LEVEL, "nivel");
		this.translationDictionary.put(LEVEL_TYPE, "tipo");
		this.translationDictionary.put(KEYBOARD_LEVEL, "conTeclado");
		this.translationDictionary.put(NO_PACMAN_LEVEL, "sinPacman");
		this.translationDictionary.put(XML_LEVEL, "conXML");
		
        this.translationDictionary.put(PACMAN_POSITION, "posicionPacman");
        this.translationDictionary.put(SENSE, "sentido");
        this.translationDictionary.put(PERSONALITY, "personalidad");
        this.translationDictionary.put(STATUS, "estado");
        this.translationDictionary.put(GHOST, "fantasma");
        this.translationDictionary.put(PACMAN, "pacman");
        this.translationDictionary.put(SCORE, "puntaje");
        this.translationDictionary.put(END_GAME, "finJuego");
        this.translationDictionary.put(NODE_WIDTH, "nodoAncho");
        this.translationDictionary.put(NODE_HEIGHT, "nodoAlto");

        this.translationDictionary.put(DIRECTION, "direccion");
        this.translationDictionary.put(DIRECTION_UP, "arriba");
        this.translationDictionary.put(DIRECTION_DOWN, "abajo");
        this.translationDictionary.put(DIRECTION_LEFT, "izquierda");
        this.translationDictionary.put(DIRECTION_RIGHT, "derecha");

        this.translationDictionary.put(LAZY_STRATEGY, "perezoso");
        this.translationDictionary.put(SILLY_STRATEGY, "zonzo");
        this.translationDictionary.put(STRATEGY_NORMAL_SEARCHER, "buscador");
        this.translationDictionary.put(STRATEGY_TEMPERAMENT_SEARCHER, "buscadorTemperamental");

        this.translationDictionary.put(CONTENT, "contiene");
        this.translationDictionary.put(DOT, "bolita");
        this.translationDictionary.put(BIG_DOT, "bolon");
		this.translationDictionary.put(FRUIT, "fruta");

        this.translationDictionary.put(HUNTER, "cazador");
        this.translationDictionary.put(DEAD, "muerto");
        this.translationDictionary.put(PREY, "presa");
    }
	
	private void fillLevelTypeValuesDictionary() {
		this.invertedLevelTypeValuesDictionary.put("conTeclado", KEYBOARD_LEVEL);
		this.invertedLevelTypeValuesDictionary.put("sinPacman", NO_PACMAN_LEVEL);
		this.invertedLevelTypeValuesDictionary.put("conXML", XML_LEVEL);
	}
	
    private void fillDirectionValuesDictionary() {
		this.invertedDirectionValuesDictionary.put("direccion", DIRECTION);
        this.invertedDirectionValuesDictionary.put("arriba", DIRECTION_UP);
        this.invertedDirectionValuesDictionary.put("abajo", DIRECTION_DOWN);
        this.invertedDirectionValuesDictionary.put("izquierda", DIRECTION_LEFT);
        this.invertedDirectionValuesDictionary.put("derecha", DIRECTION_RIGHT);
    }

    private void fillStrategyValuesDictionary() {
        this.invertedStrategyValuesDictionary.put("perezoso", LAZY_STRATEGY);
        this.invertedStrategyValuesDictionary.put("zonzo", SILLY_STRATEGY);
        this.invertedStrategyValuesDictionary.put("buscador", STRATEGY_NORMAL_SEARCHER);
        this.invertedStrategyValuesDictionary.put("buscadorTemperamental", STRATEGY_TEMPERAMENT_SEARCHER);
    }

    private void fillStatusValuesDictionary() {
        this.invertedStatusValuesDictionary.put("cazador", HUNTER);
        this.invertedStatusValuesDictionary.put("muerto", DEAD);
        this.invertedStatusValuesDictionary.put("presa", PREY);
    }
	
	private void fillItemValuesDictionary() {
        this.invertedItemValuesDictionary.put("bolita", DOT);
		this.invertedItemValuesDictionary.put("bolon", BIG_DOT);
		this.invertedItemValuesDictionary.put("fruta", FRUIT);
    }

}
