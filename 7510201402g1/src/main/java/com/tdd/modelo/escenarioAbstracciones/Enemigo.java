package com.tdd.modelo.escenarioAbstracciones;

public abstract class Enemigo extends Personaje {
	
	public Enemigo(Punto posicionRecibida) {
		super(posicionRecibida);
	}
	
    public abstract void convertirEnPresa();

}
