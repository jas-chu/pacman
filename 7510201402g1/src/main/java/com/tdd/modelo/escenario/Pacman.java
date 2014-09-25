package com.tdd.modelo.escenario;

import com.tdd.modelo.escenarioAbstracciones.Direccion;
import com.tdd.modelo.escenarioAbstracciones.Personaje;
import com.tdd.modelo.escenarioAbstracciones.Punto;

public class Pacman extends Personaje {
	
	private boolean vivo;
	
	public Pacman(Punto posicionRecibida) {
		super(posicionRecibida);
	}
	
	@Override
	public void matar() {
		this.vivo = false;
	}

	@Override
	public void revivir() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	public boolean estaVivo() {
		return this.vivo;
	}

	public void mover(Direccion dir) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
}
