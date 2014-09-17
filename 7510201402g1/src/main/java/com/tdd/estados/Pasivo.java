package com.tdd.estados;

import com.tdd.fantasma.Estado;
import com.tdd.personajesAbstractos.Enemigo;
import com.tdd.personajesAbstractos.Personaje;
        
public abstract class Pasivo implements Estado{
    protected Enemigo enemigo;
	
    public Pasivo(Enemigo enemigo){
        this.enemigo = enemigo;
    }
	
	@Override
    public void incrementarIra() {
		// por el momento no hace nada
		// permite agregar funcionalidad
    }
	
	@Override
	public abstract void serComido(Personaje p);
	
}
