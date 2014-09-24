package com.tdd.estados;

import com.tdd.configuracion.Configuracion;
import com.tdd.personajesAbstractos.Enemigo;
import com.tdd.personajesAbstractos.Personaje;
import com.tdd.personajesAbstractos.Revividor;

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
