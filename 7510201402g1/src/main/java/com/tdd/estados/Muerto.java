package com.tdd.estados;

import com.tdd.personajesAbstractos.Enemigo;
import com.tdd.personajesAbstractos.Personaje;

public class Muerto extends Pasivo{
    
    public Muerto(Enemigo enemigo){
        super(enemigo);
    }
    
	@Override
	public void serComido(Personaje p) {
		// por el momento no hace nada
		// permite agregar funcionalidad
	}
}