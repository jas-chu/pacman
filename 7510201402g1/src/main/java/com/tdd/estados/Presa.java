package com.tdd.estados;

import com.tdd.fantasma.Fantasma;

public class Presa extends Pasivo {
    
    public Presa(Fantasma fantasma){
        super(fantasma);
    }
    
    @Override
    public void incrementarIra() {
    }
    
    @Override
    public void serComido() {
        
    }
    
    @Override
    public void convertirEnPresa() {
    }
}
