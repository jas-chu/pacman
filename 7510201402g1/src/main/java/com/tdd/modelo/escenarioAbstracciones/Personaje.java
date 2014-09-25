package com.tdd.modelo.escenarioAbstracciones;

public abstract class Personaje extends ElementoDeEscenario {
	
	public Personaje(Punto posicionRecibida) {
		super(posicionRecibida);
	}
	
    public abstract void matar();
    public abstract void revivir();
	
}
