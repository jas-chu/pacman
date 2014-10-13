package com.tdd.model.languageTools;

import com.tdd.model.helpers.XMLConstants;

public class SpanishXMLConstants extends XMLConstants {

    public SpanishXMLConstants() {
        super();
        this.fillTranslationDictionary();
        this.fillDirectionValuesDictionary();
        this.fillContentValuesDictinorary();
    }

    private void fillTranslationDictionary() {
        this.translationDictionary.put(LABYRINTH, "laberinto");
        this.translationDictionary.put(NODE, "nodo");
        this.translationDictionary.put(WIDTH, "ancho");
        this.translationDictionary.put(HEIGHT, "alto");
        this.translationDictionary.put(GHOST_START, "inicioFantasmas");
        this.translationDictionary.put(PACMAN_START, "inicioPacman");
        this.translationDictionary.put(ROW, "fila");
        this.translationDictionary.put(COLUMN, "columna");
        this.translationDictionary.put(CONTENT, "contiene");
        this.translationDictionary.put(ID, "id");
        this.translationDictionary.put(DIRECTION, "direccion");
        this.translationDictionary.put(GAME, "juego");
        this.translationDictionary.put(PACMAN_POSITION, "posicionPacman");
        this.translationDictionary.put(SENSE, "sentido");
        this.translationDictionary.put(PERSONALITY, "personalidad");
        this.translationDictionary.put(STATUS, "estado");
        this.translationDictionary.put(GHOST, "fantasma");
        this.translationDictionary.put(SCORE, "puntaje");
        this.translationDictionary.put(END_GAME, "finJuego");
        this.translationDictionary.put(NODE_WIDTH, "nodoAncho");
        this.translationDictionary.put(NODE_HEIGHT, "nodoAlto");
    }

    private void fillDirectionValuesDictionary() {
        this.invertedDirectionValuesDictionary.put("arriba", DIRECTION_UP);
        this.invertedDirectionValuesDictionary.put("abajo", DIRECTION_DOWN);
        this.invertedDirectionValuesDictionary.put("izquierda", DIRECTION_LEFT);
        this.invertedDirectionValuesDictionary.put("derecha", DIRECTION_RIGHT);
    }

    private void fillContentValuesDictinorary() {
        this.translationDictionary.put(DOT, "bolita");
        this.translationDictionary.put(BIG_DOT, "bolon");
    }

}
