package com.tdd.modelo.fantasma;

import com.tdd.modelo.escenarioAbstracciones.Punto;
import com.tdd.modelo.estados.Cazador;
import com.tdd.modelo.estados.Muerto;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class MuertoTest {
	
	private Punto posicion;
	private Fantasma fantasma;
	
    public MuertoTest() {
    }
	
	@Before
	public void setUp() {
		posicion = new Punto(0,0);
		fantasma = new Fantasma(posicion);
	}
	
    @Test
    public void testSerComido() {
        Fantasma enemigo = new Fantasma(posicion);
        Cazador cazador = new Cazador(enemigo);
        fantasma.matar();
        cazador.serComido(fantasma);
        assertEquals(Muerto.class, fantasma.obtenerEstado().getClass());
    }
}
