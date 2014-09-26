package com.tdd.modelo.estados;

import com.tdd.modelo.configuracion.Configuracion;
import com.tdd.model.stageAbstractions.Direction;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.StageCharacter;
import com.tdd.model.stageAbstractions.Revividor;

public class Muerto extends Pasivo {

    public Muerto(Enemy enemigo) {
        super(enemigo, new Revividor(enemigo), Muerto.obtenerTiempoMuerto());
    }

    @Override
    public void serComido(StageCharacter p) {
	// por el momento no hace nada
        // permite agregar funcionalidad
    }

    private static int obtenerTiempoMuerto() {
        return Configuracion.getConfiguracion().getTiempoMuerto().intValue();
    }

	@Override
	public Direction getDireccion(Direction direccionRecibida) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
}
