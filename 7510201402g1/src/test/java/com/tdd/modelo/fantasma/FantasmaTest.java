package com.tdd.modelo.fantasma;

import com.tdd.modelo.escenarioAbstracciones.Punto;
import com.tdd.modelo.estados.Cazador;
import com.tdd.modelo.estados.Muerto;
import com.tdd.modelo.estados.Presa;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class FantasmaTest {
	
	private Punto posicion;
	private Fantasma fantasma;
	
    public FantasmaTest() {
    }
	
	@Before
	public void setUp() {
		posicion = new Punto(0,0);
		fantasma = new Fantasma(posicion);
	}
	
    @Test
    public void testCrearComoCazador() {
        assertEquals(Cazador.class, fantasma.obtenerEstado().getClass());
    }

    @Test
    public void testMatar() {
        fantasma.matar();
        assertEquals(Muerto.class, fantasma.obtenerEstado().getClass());
    }

    @Test
    public void testConvertirEnPresa() {
        fantasma.convertirEnPresa();
        assertEquals(Presa.class, fantasma.obtenerEstado().getClass());
    }

    @Test
    public void testRevivirComoCazador() {
        fantasma.matar();
        fantasma.revivir();
        assertEquals(Cazador.class, fantasma.obtenerEstado().getClass());
    }
}
