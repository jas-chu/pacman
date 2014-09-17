package com.tdd.fantasma;

import com.tdd.estados.*;
import com.tdd.personajesAbstractos.*;

public class Fantasma extends Personaje implements Enemigo {
    private Estado estado;
    
    public Fantasma(){
        this.estado = new Cazador(this);
    }

	@Override
	public void matar() {
		this.estado = new Muerto(this);
	}
    
	@Override
	public void convertirEnPresa() {
		this.estado = new Presa(this);
    }
	
}
