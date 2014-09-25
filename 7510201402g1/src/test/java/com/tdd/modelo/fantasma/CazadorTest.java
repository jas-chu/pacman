package com.tdd.modelo.fantasma;

import com.tdd.modelo.escenarioAbstracciones.Punto;
import com.tdd.modelo.fantasma.Fantasma;
import com.tdd.modelo.estados.Cazador;
import com.tdd.modelo.estados.Muerto;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class CazadorTest {
	
	private Punto posicion;
	private Fantasma fantasma;
	
    public CazadorTest() {
    }
	
	@Before
	public void setUp() {
		posicion = new Punto(0,0);
		fantasma = new Fantasma(posicion);
	}
	
    @Test
    public void testNivelIra() {
        Cazador cazador = new Cazador(fantasma);
        assertEquals(cazador.obtenerNivelIra(), 0);
        cazador.incrementarIra();
        assertEquals(cazador.obtenerNivelIra(), 1);
    }

    @Test
    public void testSerComido() {
        Fantasma enemigo = new Fantasma(posicion);
        Cazador cazador = new Cazador(enemigo);
        fantasma.convertirEnPresa();
        cazador.serComido(fantasma);
        assertEquals(Muerto.class, fantasma.obtenerEstado().getClass());
    }
}
