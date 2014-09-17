package com.tdd.fantasma;

import com.tdd.estados.Muerto;
import com.tdd.personajesAbstractos.*;

public class Fantasma extends Personaje implements Enemigo {
    private Estado estado;
    
    public Fantasma(){
        estado = new Muerto(this);
    }
    
}
