package com.tdd.modelo.escenarioAbstracciones;

public abstract class Personaje {
	
	protected Punto posicion;
	
	public Personaje(Punto posicionRecibida) {
		this.posicion = new Punto(posicionRecibida);
	}
	
    public abstract void matar();
    public abstract void revivir();

	public boolean estoyEnArea(AreaCuadrada area) {
		return area.puntoFormaParte(this.posicion);
	}
	
}
