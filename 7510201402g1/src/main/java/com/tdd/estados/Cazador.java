package com.tdd.estados;

import com.tdd.fantasma.Estado;
import com.tdd.personajesAbstractos.Enemigo;
import com.tdd.personajesAbstractos.Personaje;

public class Cazador implements Estado {
	
    private Enemigo enemigo;
	
    public Cazador(Enemigo enemigo){
        this.enemigo = enemigo;
    }
	
	@Override
    public void incrementarIra() {
    }
    
    @Override
	public void serComido(Personaje p) {
		p.matar();
	}
}