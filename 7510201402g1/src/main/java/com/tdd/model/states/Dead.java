package com.tdd.model.states;

import com.tdd.model.configuration.Configuration;
import com.tdd.model.stageAbstractions.Direction;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.StageCharacter;
import com.tdd.model.stageAbstractions.Revividor;

public class Dead extends Passive {

    public Dead(Enemy enemigo) {
        super(enemigo, new Revividor(enemigo), Dead.getDeadTime());
    }

    @Override
    public void beEaten(StageCharacter p) {
        // por el momento no hace nada
        // permite agregar funcionalidad
    }

    private static int getDeadTime() {
        return Configuration.getConfiguracion().getTiempoMuerto().intValue();
    }

    @Override
    public Direction getDirection(Direction givenDirection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
