package com.tdd.estados;

import com.tdd.fantasma.Estado;
import com.tdd.fantasma.IncrementadorDeIra;
import com.tdd.personajesAbstractos.Enemigo;
import com.tdd.personajesAbstractos.Personaje;
import java.util.Timer;

public class Cazador implements Estado {
	
    private Enemigo enemigo;
	private Timer temporizador;
	private int nivelIra;
	private int cantidadNivelesIra;
	private int[] tiemposDeEspera;
	
	public Cazador (Enemigo e) {
		this.configurarCazador();
		
		this.enemigo = e;
		this.nivelIra = 0;
		
		this.temporizador = new Timer();
		int acumulado = 0;
		for (int i = this.nivelIra ; i < tiemposDeEspera.length ; ++i) {
			acumulado += tiemposDeEspera[i];
			this.temporizador.schedule(new IncrementadorDeIra(this), acumulado);
		}
	}
	
	@Override
    public void incrementarIra() {
		if (this.nivelIra < this.cantidadNivelesIra) this.nivelIra++;
    }
    
    @Override
	public void serComido(Personaje p) {
		p.matar();
	}
	
	private void configurarCazador() {
		// TODO: Usar clase Configuracion
		this.cantidadNivelesIra = 3;
		tiemposDeEspera[0] = 1000; //millisegundos
		tiemposDeEspera[1] = 1000;
		tiemposDeEspera[2] = 1000;
	}
	
}