package com.tdd.modelo.estados;

import com.tdd.modelo.configuracion.Configuracion;
import com.tdd.modelo.escenarioAbstracciones.Enemigo;
import com.tdd.modelo.escenarioAbstracciones.Personaje;
import com.tdd.modelo.escenarioAbstracciones.Revividor;

public class Presa extends Pasivo {

    public Presa(Enemigo enemigo) {
        super(enemigo, new Revividor(enemigo), Presa.obtenerTiempoPresa());
    }

    @Override
    public void serComido(Personaje p) {
        this.enemigo.matar();
    }

    private static int obtenerTiempoPresa() {
        return Configuracion.getConfiguracion().getTiempoPresa().intValue();
    }

}
