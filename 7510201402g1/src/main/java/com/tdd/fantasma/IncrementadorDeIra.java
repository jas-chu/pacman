package com.tdd.fantasma;

import java.util.TimerTask;

public class IncrementadorDeIra extends TimerTask {

	private Estado estado;

	public IncrementadorDeIra (Estado e) {
		super();
		this.estado = e;
	}

	@Override
	public void run() {
		this.estado.incrementarIra();
	}
	
}
