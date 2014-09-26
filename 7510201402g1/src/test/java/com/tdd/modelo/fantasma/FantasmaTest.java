package com.tdd.modelo.fantasma;

import com.tdd.model.stageAbstractions.Position;
import com.tdd.modelo.estados.Cazador;
import com.tdd.modelo.estados.Muerto;
import com.tdd.modelo.estados.Presa;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class FantasmaTest {
	
	private Position posicion;
	private Fantasma fantasma;
	
    public FantasmaTest() {
    }
	
	@Before
	public void setUp() {
		posicion = new Position(0,0);
		fantasma = new Fantasma(posicion);
	}
	
    @Test
    public void testCrearComoCazador() {
        assertEquals(Cazador.class, fantasma.obtenerEstado().getClass());
    }

    @Test
    public void testMatar() {
        fantasma.kill();
        assertEquals(Muerto.class, fantasma.obtenerEstado().getClass());
    }

    @Test
    public void testConvertirEnPresa() {
        fantasma.turnToPrey();
        assertEquals(Presa.class, fantasma.obtenerEstado().getClass());
    }

    @Test
    public void testRevivirComoCazador() {
        fantasma.kill();
        fantasma.revive();
        assertEquals(Cazador.class, fantasma.obtenerEstado().getClass());
    }
}
