package com.tdd.fantasma;

import com.tdd.estados.Cazador;
import com.tdd.estados.Muerto;
import com.tdd.estados.Presa;
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
