package com.tdd.modelo.escenario;

import com.tdd.helpers.LectorXML;
import com.tdd.modelo.escenarioAbstracciones.Enemigo;
import com.tdd.modelo.escenarioAbstracciones.Item;
import java.util.ArrayList;
import org.w3c.dom.Node;

public class Laberinto {
	
	private ArrayList<Item> items;
	private ArrayList<Enemigo> enemigos;
	private Pacman pacman;
	
	public Laberinto(String rutaXML) {
		Node nodoRaiz = LectorXML.getNodoRaiz(rutaXML);
		/* TODO:
			Recorrer el nodo y por cada elemento llamar a una instancia factory
			para que me cree la entidad que corresponda y lo agregue a la lista
			adecuada.
		*/
	}
	
	public ArrayList<Item> getItems() {
		return items;
	}
	
	public ArrayList<Enemigo> getEnemigos() {
		return enemigos;
	}
	
	public Pacman getPacman() {
		return pacman;
	}

	public boolean tieneItems() {
		return !(this.items.isEmpty());
	}
	
}
