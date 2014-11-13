/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tdd.view.stage.labyrinth;

import com.tdd.model.helpers.XMLConstants;
import com.tdd.model.stageAbstractions.Cell;
import com.tdd.view.Observador;
import java.util.HashMap;
import java.util.Map;
import java.util.Observable;

/**
 *
 * 
 */
public class CellView extends Observador{
	
	// STATIC
	private static final double RIGHT_POW = 0.0;
	private static final double UP_POW = 1.0;
	private static final double LEFT_POW = 2.0;
	private static final double DOWN_POW = 3.0;
	private static final Map<Integer,String> RESOURCES = createResources();
	
	private static int getPowValue(double theDouble) {
		return (int)Math.pow(2, theDouble);
	}
	
	private static int boolToInt(boolean bool) {
		if (bool) return 0;
		return 1;
	}
	
	// TO DO: COMPLETAR PATHS A IMAGENES
	private static Map<Integer, String> createResources() {
		Map<Integer, String> theResources = new HashMap<Integer, String>();
		theResources.put(0, "PATH DE IMAGEN SIN BORDES");
		
		// UN BORDE
		theResources.put(getPowValue(RIGHT_POW), "PATH DE IMAGEN SOLO BORDE DERECHO");
		theResources.put(getPowValue(UP_POW), "PATH DE IMAGEN SOLO BORDE SUPERIOR");
		theResources.put(getPowValue(LEFT_POW), "PATH DE IMAGEN SOLO BORDE IZQUIERDO");
		theResources.put(getPowValue(DOWN_POW), "PATH DE IMAGEN SOLO BORDE INFERIOR");
		
		// DOS BORDES
		theResources.put(getPowValue(RIGHT_POW) + getPowValue(UP_POW), "PATH DE IMAGEN SOLO BORDES DERECHO Y SUPERIOR");
		theResources.put(getPowValue(RIGHT_POW) + getPowValue(LEFT_POW), "PATH DE IMAGEN SOLO BORDES DERECHO E IZQUIERDO");
		theResources.put(getPowValue(RIGHT_POW) + getPowValue(DOWN_POW), "PATH DE IMAGEN SOLO BORDES DERECHO E INFERIOR");
		theResources.put(getPowValue(UP_POW) + getPowValue(LEFT_POW), "PATH DE IMAGEN SOLO BORDES SUPERIOR E IZQUIERDO");
		theResources.put(getPowValue(UP_POW) + getPowValue(DOWN_POW), "PATH DE IMAGEN SOLO BORDES SUPERIOR E INFERIOR");
		theResources.put(getPowValue(LEFT_POW) + getPowValue(DOWN_POW), "PATH DE IMAGEN SOLO BORDES IZQUIERDO E INFERIOR");
		
		// TRES BORDES
		theResources.put(getPowValue(RIGHT_POW) + getPowValue(UP_POW) + getPowValue(LEFT_POW), "PATH DE IMAGEN SOLO BORDES DERECHO, SUPERIOR E IZQUIERDO");
		theResources.put(getPowValue(RIGHT_POW) + getPowValue(UP_POW) + getPowValue(DOWN_POW), "PATH DE IMAGEN SOLO BORDES DERECHO, SUPERIOR E INFERIOR");
		theResources.put(getPowValue(RIGHT_POW) + getPowValue(LEFT_POW) + getPowValue(DOWN_POW), "PATH DE IMAGEN SOLO BORDES DERECHO, IZQUIERDO E INFERIOR");
		theResources.put(getPowValue(UP_POW) + getPowValue(LEFT_POW) + getPowValue(DOWN_POW), "PATH DE IMAGEN SOLO BORDES SUPERIOR, IZQUIERDO E INFERIOR");
		
		// CUATRO BORDES
		theResources.put(getPowValue(RIGHT_POW) + getPowValue(UP_POW) + getPowValue(LEFT_POW) + getPowValue(DOWN_POW), "PATH DE IMAGEN CON TODOS LOS BORDES");
		
		return theResources;
	}
	
	
	// INSTANCE
	
	private String resourcePath;
	
	public CellView(Cell cell) {
        this.observable = cell;
		int index = this.getImageIndex(cell);
		this.resourcePath = RESOURCES.get(index);
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("actualizacion de " + o + arg);
    }
	
	private int getImageIndex(Cell cell) {
		int index = getPowValue(RIGHT_POW) * boolToInt(cell.hasNeighbour(XMLConstants.DIRECTION_RIGHT));
		index += getPowValue(UP_POW) * boolToInt(cell.hasNeighbour(XMLConstants.DIRECTION_UP));
		index += getPowValue(LEFT_POW) * boolToInt(cell.hasNeighbour(XMLConstants.DIRECTION_LEFT));
		index += getPowValue(DOWN_POW) * boolToInt(cell.hasNeighbour(XMLConstants.DIRECTION_DOWN));
		return index;
	}
	
	
	
}
