package com.tdd.modelo.fantasma;

import com.tdd.modelo.escenarioAbstracciones.Personaje;

public interface Estado {

    public void incrementarIra();

    public void serComido(Personaje p);

}
