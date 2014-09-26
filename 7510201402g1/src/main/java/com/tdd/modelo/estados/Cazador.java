package com.tdd.modelo.estados;

import com.tdd.modelo.configuracion.Configuracion;
import com.tdd.model.stageAbstractions.Direction;
import com.tdd.modelo.fantasma.Estado;
import com.tdd.modelo.fantasma.IncrementadorDeIra;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.StageCharacter;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class Cazador implements Estado {

    private Enemy enemigo;
    private Timer temporizador;
    private int nivelIra;
    private int cantidadNivelesIra;
    private List<Long> tiemposDeEspera;

    public Cazador(Enemy e) {
        this.configurarCazador();

        this.enemigo = e;
        this.nivelIra = 0;

        this.temporizador = new Timer();
        int acumulado = 0;
        for (Long tiempo : tiemposDeEspera) {
            acumulado += tiempo;
            this.temporizador.schedule(new IncrementadorDeIra(this), acumulado);
        }
    }

    @Override
    public void incrementarIra() {
        if (this.nivelIra < this.cantidadNivelesIra) {
            this.nivelIra++;
        }
    }

    @Override
    public void serComido(StageCharacter p) {
        p.kill();
    }

    private void configurarCazador() {
        this.tiemposDeEspera = new ArrayList<>();
        this.cantidadNivelesIra = 3;
        Configuracion configuracion = Configuracion.getConfiguracion();
        for (Long tiempo : configuracion.getTiemposCazador()) {
            tiemposDeEspera.add(tiempo);
        }
    }
    
    public int obtenerNivelIra(){
        return this.nivelIra;
    }

	@Override
	public Direction getDireccion(Direction direccionRecibida) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}

}
