package com.tdd.model.ghost;

import com.tdd.model.stageAbstractions.Direction;
import com.tdd.model.stageAbstractions.Enemy;

public abstract class Strategy {

    protected Enemy enemy;

    public Strategy(Enemy givenEnemy) {
        this.enemy = givenEnemy;
    }

    public Direction getDirection(){
        throw new UnsupportedOperationException("Not supported yet.");
//        buscar pacman en area:
//	si no lo ve:
//		se mueve random o va a la ultima posicion (uno u otro par de estrategias(*))
//	si lo ve:
//		lo persigue(en comun para los 4)

    }

    public abstract void advanceCycle();

    // ojo: no es random random sino que tiene logica de seguir canales del laberinto.
    // y solo es random en los cruces.
    public abstract Direction getRandomDirection();
    
    public abstract Direction chasePacman();
        

}
