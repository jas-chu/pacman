package com.tdd.modelo.fantasma;

import com.tdd.modelo.escenarioAbstracciones.Punto;
import com.tdd.modelo.fantasma.Fantasma;
import com.tdd.modelo.estados.Muerto;
import com.tdd.modelo.estados.Presa;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class PresaTest {
	
	private Punto posicion;
	private Fantasma fantasma;
	
    public PresaTest() {
    }
	
	@Before
	public void setUp() {
		posicion = new Punto(0,0);
		fantasma = new Fantasma(posicion);
	}
	
    @Test
    public void testSerComido() {
        Presa presa = new Presa(fantasma);
        presa.serComido(fantasma);
        assertEquals(Muerto.class, fantasma.obtenerEstado().getClass());
    }

}
