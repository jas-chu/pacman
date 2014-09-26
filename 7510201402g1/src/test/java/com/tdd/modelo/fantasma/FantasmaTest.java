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
    public void CrearComoCazador() {
        assertEquals(Cazador.class, fantasma.obtenerEstado().getClass());
    }

    @Test
    public void Matar() {
        fantasma.kill();
        assertEquals(Muerto.class, fantasma.obtenerEstado().getClass());
    }

    @Test
    public void ConvertirEnPresa() {
        fantasma.turnToPrey();
        assertEquals(Presa.class, fantasma.obtenerEstado().getClass());
    }

    @Test
    public void RevivirComoCazador() {
        fantasma.kill();
        fantasma.revive();
        assertEquals(Cazador.class, fantasma.obtenerEstado().getClass());
    }
}
