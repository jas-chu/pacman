package com.tdd.fantasma;

import com.tdd.estados.*;
import com.tdd.personajesAbstractos.*;

public class Fantasma extends Enemigo {
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

    @Override
    public void revivir() {
            this.estado = new Cazador(this);
    }
    
    public Estado obtenerEstado(){
        return this.estado;
    }	
}
