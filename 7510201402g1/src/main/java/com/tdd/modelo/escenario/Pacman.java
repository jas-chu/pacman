package com.tdd.modelo.escenario;

import com.tdd.modelo.escenarioAbstracciones.Personaje;
import com.tdd.modelo.escenarioAbstracciones.Punto;

public class Pacman extends Personaje {
	
	public Pacman(Punto posicionRecibida) {
		super(posicionRecibida);
	}
	
	@Override
	public void matar() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

	@Override
	public void revivir() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
}
