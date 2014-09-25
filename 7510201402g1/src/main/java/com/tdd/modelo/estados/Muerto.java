package com.tdd.modelo.estados;

import com.tdd.modelo.configuracion.Configuracion;
import com.tdd.modelo.escenarioAbstracciones.Direccion;
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

	@Override
	public Direccion getDireccion(Direccion direccionRecibida) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
}
