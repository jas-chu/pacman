package com.tdd.estados;

import com.tdd.personajesAbstractos.Enemigo;
import com.tdd.personajesAbstractos.Personaje;

public class Presa extends Pasivo {
    
    public Presa(Enemigo enemigo){
        super(enemigo);
    }
    
    @Override
	public void serComido(Personaje p) {
		this.enemigo.matar();
	}
    
}
