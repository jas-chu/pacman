package com.tdd.modelo.fantasma;

import com.tdd.model.stageAbstractions.Direction;
import com.tdd.model.stageAbstractions.StageCharacter;

public interface Estado {

    public void incrementarIra();

    public void serComido(StageCharacter p);
	
	public Direction getDireccion(Direction direccionRecibida);

}
