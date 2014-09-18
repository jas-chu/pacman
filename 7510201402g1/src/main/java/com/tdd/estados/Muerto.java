package com.tdd.estados;

import com.tdd.configuracion.Configuracion;
import com.tdd.personajesAbstractos.Enemigo;
import com.tdd.personajesAbstractos.Personaje;
import com.tdd.personajesAbstractos.Revividor;

public class Muerto extends Pasivo {

    public Muerto(Enemigo enemigo) {
        super(enemigo, new Revividor(enemigo), Muerto.obtenerTiempoMuerto());
    }

    @Override
    public void serComido(Personaje p) {
	// por el momento no hace nada
        // permite agregar funcionalidad
    }

    private static int obtenerTiempoMuerto() {
        return Configuracion.getConfiguracion().getTiempoMuerto().intValue();
    }
}
