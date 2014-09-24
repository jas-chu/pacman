package com.tdd.modelo.fantasma;

import com.tdd.modelo.fantasma.Fantasma;
import com.tdd.modelo.estados.Cazador;
import com.tdd.modelo.estados.Muerto;
import com.tdd.modelo.estados.Presa;
import static org.junit.Assert.*;
import org.junit.Test;

public class FantasmaTest {

    public FantasmaTest() {
    }

    @Test
    public void testCrearComoCazador() {
        Fantasma fantasma = new Fantasma();
        assertEquals(Cazador.class, fantasma.obtenerEstado().getClass());
    }

    @Test
    public void testMatar() {
        Fantasma fantasma = new Fantasma();
        fantasma.matar();
        assertEquals(Muerto.class, fantasma.obtenerEstado().getClass());
    }

    @Test
    public void testConvertirEnPresa() {
        Fantasma fantasma = new Fantasma();
        fantasma.convertirEnPresa();
        assertEquals(Presa.class, fantasma.obtenerEstado().getClass());
    }

    @Test
    public void testRevivirComoCazador() {
        Fantasma fantasma = new Fantasma();
        fantasma.matar();
        fantasma.revivir();
        assertEquals(Cazador.class, fantasma.obtenerEstado().getClass());
    }
}
