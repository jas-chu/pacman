package com.tdd.estados;

import com.tdd.fantasma.Estado;
import com.tdd.personajesAbstractos.Enemigo;
import com.tdd.personajesAbstractos.Personaje;
import java.util.Timer;
import java.util.TimerTask;

public abstract class Pasivo implements Estado {

    protected Enemigo enemigo;
    private Timer temporizador;

    public Pasivo(Enemigo enemigo, TimerTask tarea, int tiempoDeEspera) {
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
    public abstract void serComido(Personaje p);

}
