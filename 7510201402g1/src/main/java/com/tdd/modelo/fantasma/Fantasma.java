package com.tdd.modelo.fantasma;

import com.tdd.modelo.estados.Muerto;
import com.tdd.modelo.estados.Presa;
import com.tdd.modelo.estados.Cazador;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.Position;

public class Fantasma extends Enemy {
    private Estado estado;
    
    public Fantasma(Position posicionRecibida){
		super(posicionRecibida);
        this.estado = new Cazador(this);
    }

    @Override
    public void kill() {
            this.estado = new Muerto(this);
    }

    @Override
    public void turnToPrey() {
            this.estado = new Presa(this);
    }

    @Override
    public void revive() {
            this.estado = new Cazador(this);
    }
    
    public Estado obtenerEstado(){
        return this.estado;
    }	

	@Override
	public void move() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
}
