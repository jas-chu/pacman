package com.tdd.modelo.estados;

import com.tdd.modelo.configuracion.Configuracion;
import com.tdd.modelo.escenarioAbstracciones.Enemigo;
import com.tdd.modelo.escenarioAbstracciones.Personaje;
import com.tdd.modelo.escenarioAbstracciones.Revividor;

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
