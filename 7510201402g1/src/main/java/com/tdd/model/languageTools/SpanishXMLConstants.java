package com.tdd.model.languageTools;

import com.tdd.model.helpers.XMLConstants;

public class SpanishXMLConstants extends XMLConstants {

    public SpanishXMLConstants() {
        super();
        this.fillTranslationDictionary();
        this.fillDirectionValuesDictionary();
		this.fillStrategyValuesDictionary();
    }

    private void fillTranslationDictionary() {
		this.translationDictionary.put(TICK, "Tick");
        this.translationDictionary.put(LABYRINTH, "laberinto");
        this.translationDictionary.put(NODE, "nodo");
        this.translationDictionary.put(WIDTH, "ancho");
        this.translationDictionary.put(HEIGHT, "alto");
        this.translationDictionary.put(GHOST_START, "inicioFantasmas");
        this.translationDictionary.put(PACMAN_START, "inicioPacman");
        this.translationDictionary.put(ROW, "fila");
        this.translationDictionary.put(COLUMN, "columna");
        this.translationDictionary.put(ID, "id");
        this.translationDictionary.put(GAME, "juego");
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
    }

    private void fillDirectionValuesDictionary() {
        this.invertedDirectionValuesDictionary.put("arriba", DIRECTION_UP);
        this.invertedDirectionValuesDictionary.put("abajo", DIRECTION_DOWN);
        this.invertedDirectionValuesDictionary.put("izquierda", DIRECTION_LEFT);
        this.invertedDirectionValuesDictionary.put("derecha", DIRECTION_RIGHT);
    }
	
	private void fillStrategyValuesDictionary() {
        this.invertedDirectionValuesDictionary.put("perezoso", LAZY_STRATEGY);
        this.invertedDirectionValuesDictionary.put("zonzo", SILLY_STRATEGY);
        this.invertedDirectionValuesDictionary.put("buscador", STRATEGY_NORMAL_SEARCHER);
        this.invertedDirectionValuesDictionary.put("buscadorTemperamental", STRATEGY_TEMPERAMENT_SEARCHER);
    }

}
