package com.tdd.aplicacion;

import com.tdd.modelo.escenario.Laberinto;
import com.tdd.modelo.escenario.Pacman;
import com.tdd.modelo.escenarioAbstracciones.Enemigo;
import com.tdd.modelo.escenarioAbstracciones.Item;
import java.util.ArrayList;

public class Partida {
	
	private Laberinto laberinto;
	private ArrayList<Enemigo> enemigos;
	private Pacman pacman;
	private ControladorJugador controlador;
	
	public Partida(String rutaXML) {
		this.laberinto = new Laberinto(rutaXML);
		this.enemigos = this.laberinto.getEnemigos();
		this.pacman = this.laberinto.getPacman();
		ArrayList<Item> items = this.laberinto.getItems();
		
		this.controlador = new ControladorJugador(this.pacman);
		this.crearVistas(items);
	}

	private void crearVistas(ArrayList<Item> items) {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
	public void gameloop() {
		boolean seguirPartida = false;
		while (!seguirPartida) {
			this.controlador.procesarMovimiento();
			this.actualizarEnemigos();
			this.actualizarVistas();
			seguirPartida = (this.laberinto.tieneItems() && this.pacman.estaVivo());
		}
	}

	private void actualizarEnemigos() {
		for (Enemigo enemigo : this.enemigos) {
			enemigo.mover();
		}
	}

	private void actualizarVistas() {
		throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
	}
	
}
