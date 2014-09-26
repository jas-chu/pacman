package com.tdd.modelo.estados;

import com.tdd.modelo.configuracion.Configuracion;
import com.tdd.model.stageAbstractions.Direction;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.StageCharacter;
import com.tdd.model.stageAbstractions.Revividor;

public class Presa extends Pasivo {

    public Presa(Enemy enemigo) {
        super(enemigo, new Revividor(enemigo), Presa.obtenerTiempoPresa());
    }

    @Override
    public void serComido(StageCharacter p) {
        this.enemigo.kill();
    }

    private static int obtenerTiempoPresa() {
        return Configuracion.getConfiguracion().getTiempoPresa().intValue();
    }

	@Override
	public Direction getDireccion(Direction direccionRecibida) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

}
