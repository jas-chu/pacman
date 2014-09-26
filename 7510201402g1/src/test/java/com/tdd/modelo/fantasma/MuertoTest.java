package com.tdd.modelo.fantasma;

import com.tdd.model.stageAbstractions.Position;
import com.tdd.modelo.estados.Cazador;
import com.tdd.modelo.estados.Muerto;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class MuertoTest {
	
	private Position posicion;
	private Fantasma fantasma;
	
    public MuertoTest() {
    }
	
	@Before
	public void setUp() {
		posicion = new Position(0,0);
		fantasma = new Fantasma(posicion);
	}
	
    @Test
    public void testSerComido() {
        Fantasma enemigo = new Fantasma(posicion);
        Cazador cazador = new Cazador(enemigo);
        fantasma.kill();
        cazador.serComido(fantasma);
        assertEquals(Muerto.class, fantasma.obtenerEstado().getClass());
    }
}
