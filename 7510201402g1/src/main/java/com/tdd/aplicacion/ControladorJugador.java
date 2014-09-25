package com.tdd.aplicacion;

import com.tdd.modelo.direcciones.DireccionDerecha;
import com.tdd.modelo.escenario.Pacman;
import com.tdd.modelo.escenarioAbstracciones.Direccion;

public class ControladorJugador {
	
	private Pacman pacman;
	
	ControladorJugador(Pacman pacmanRecibido) {
		this.pacman = pacmanRecibido;
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	void procesarMovimiento() {
		Direccion dir = new DireccionDerecha();
		this.pacman.mover(dir);
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
}
