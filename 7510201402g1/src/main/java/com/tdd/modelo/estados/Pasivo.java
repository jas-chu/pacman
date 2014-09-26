package com.tdd.modelo.estados;

import com.tdd.modelo.fantasma.Estado;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.StageCharacter;
import java.util.Timer;
import java.util.TimerTask;

public abstract class Pasivo implements Estado {

    protected Enemy enemigo;
    private Timer temporizador;

    public Pasivo(Enemy enemigo, TimerTask tarea, int tiempoDeEspera) {
        this.enemigo = enemigo;
        this.temporizador = new Timer();
        this.temporizador.schedule(tarea, tiempoDeEspera);
    }

    @Override
    public void incrementarIra() {
	// por el momento no hace nada
        // permite agregar funcionalidad
    }

    @Override
    public abstract void serComido(StageCharacter p);

}
