package com.tdd.estados;

import com.tdd.fantasma.*;
        
public abstract class Pasivo implements Estado{
    private Fantasma fantasma;
    public Pasivo(Fantasma fantasma){
        this.fantasma = fantasma;
    }
}
