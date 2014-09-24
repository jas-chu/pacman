package com.tdd.fantasma;

import com.tdd.estados.Muerto;
import com.tdd.estados.Presa;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PresaTest {

    public PresaTest() {
    }

    @Test
    public void testSerComido() {
        Fantasma fantasma = new Fantasma();
        Presa presa = new Presa(fantasma);
        presa.serComido(fantasma);
        assertEquals(Muerto.class, fantasma.obtenerEstado().getClass());
    }

}
