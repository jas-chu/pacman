package com.tdd.modelo.fantasma;

import com.tdd.modelo.escenarioAbstracciones.Direccion;

public abstract class Estrategia {
	
	public abstract Direccion getDireccion();
	
	public abstract void avanzarCiclo();
	
}
