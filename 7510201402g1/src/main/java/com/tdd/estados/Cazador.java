package com.tdd.estados;

import com.tdd.fantasma.Estado;
import com.tdd.fantasma.IncrementadorDeIra;
import com.tdd.personajesAbstractos.Enemigo;
import com.tdd.personajesAbstractos.Personaje;
import java.util.Timer;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Cazador implements Estado {
	
    private Enemigo enemigo;
	private Timer temporizador;
	private int nivelIra;
	private int cantidadNivelesIra;
	private int[] delays;
	
	public Cazador (Enemigo e) {
		this.configurarCazador();
		
		this.enemigo = e;
		this.nivelIra = 0;
		
		this.temporizador = new Timer();
		for (int i = this.nivelIra ; i < delays.length ; ++i)
			this.temporizador.schedule(new IncrementadorDeIra(this), delays[i]);
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
		delays[0] = 1000; //milliseconds
		delays[1] = 1000;
		delays[2] = 1000;
	}
	
}