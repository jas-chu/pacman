package com.tdd.fantasma;

import com.tdd.estados.Cazador;
import com.tdd.estados.Muerto;
import static org.junit.Assert.*;
import org.junit.Test;

public class CazadorTest {

    public CazadorTest() {
    }

    @Test
    public void testNivelIra() {
        Fantasma fantasma = new Fantasma();
        Cazador cazador = new Cazador(fantasma);
        assertEquals(cazador.obtenerNivelIra(), 0);
        cazador.incrementarIra();
        assertEquals(cazador.obtenerNivelIra(), 1);
    }

    @Test
    public void testSerComido() {
        Fantasma fantasma = new Fantasma();
        Fantasma enemigo = new Fantasma();
        Cazador cazador = new Cazador(enemigo);
        fantasma.convertirEnPresa();
        cazador.serComido(fantasma);
        assertEquals(Muerto.class, fantasma.obtenerEstado().getClass());
    }
}
