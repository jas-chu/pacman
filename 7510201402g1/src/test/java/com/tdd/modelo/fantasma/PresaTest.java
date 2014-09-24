package com.tdd.modelo.fantasma;

import com.tdd.modelo.fantasma.Fantasma;
import com.tdd.modelo.estados.Muerto;
import com.tdd.modelo.estados.Presa;
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
