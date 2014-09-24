package com.tdd.fantasma;

import com.tdd.estados.Cazador;
import com.tdd.estados.Muerto;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class MuertoTest {

    public MuertoTest() {
    }

    @Test
    public void testSerComido() {
        Fantasma fantasma = new Fantasma();
        Fantasma enemigo = new Fantasma();
        Cazador cazador = new Cazador(enemigo);
        fantasma.matar();
        cazador.serComido(fantasma);
        assertEquals(Muerto.class, fantasma.obtenerEstado().getClass());
    }
}
