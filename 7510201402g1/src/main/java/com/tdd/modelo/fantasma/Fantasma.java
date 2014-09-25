package com.tdd.modelo.fantasma;

import com.tdd.modelo.estados.Muerto;
import com.tdd.modelo.estados.Presa;
import com.tdd.modelo.estados.Cazador;
import com.tdd.modelo.escenarioAbstracciones.Enemigo;
import com.tdd.modelo.escenarioAbstracciones.Punto;

public class Fantasma extends Enemigo {
    private Estado estado;
    
    public Fantasma(Punto posicionRecibida){
		super(posicionRecibida);
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

    @Override
    public void revivir() {
            this.estado = new Cazador(this);
    }
    
    public Estado obtenerEstado(){
        return this.estado;
    }	
}
