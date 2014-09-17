package com.tdd.personajesAbstractos;

import java.util.TimerTask;

public class Revividor extends TimerTask {

	private Personaje personaje;

	public Revividor (Personaje p) {
		super();
		this.personaje = p;
	}

	@Override
	public void run() {
		this.personaje.revivir();
	}
	
}