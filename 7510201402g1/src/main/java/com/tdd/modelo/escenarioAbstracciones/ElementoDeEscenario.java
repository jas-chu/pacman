package com.tdd.modelo.escenarioAbstracciones;

public abstract class ElementoDeEscenario {
	
	protected Punto posicion;
	
	public ElementoDeEscenario(Punto posicionRecibida) {
		this.posicion = new Punto(posicionRecibida);
	}

	public boolean estoyEnArea(AreaCuadrada area) {
		return area.puntoFormaParte(this.posicion);
	}
	
}
