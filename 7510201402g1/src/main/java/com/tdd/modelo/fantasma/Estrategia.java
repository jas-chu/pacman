package com.tdd.modelo.fantasma;

import com.tdd.model.stageAbstractions.Direction;

public abstract class Estrategia {
	
	public abstract Direction getDireccion();
	
	public abstract void avanzarCiclo();
	
}
