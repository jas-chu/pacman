package com.tdd.model.ghost;

import com.tdd.model.stage.SquaredArea;
import com.tdd.model.stageAbstractions.Direction;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.Protagonist;

public abstract class Strategy {

    protected Enemy enemy;
    protected int vision;

    public Strategy(Enemy givenEnemy) {
        this.enemy = givenEnemy;
    }

    //TODO: terminar
    public Direction getDirection(){
        Direction direction;
        SquaredArea area = new SquaredArea(this.enemy.getPosition(), this.vision);
        Protagonist pacman = this.enemy.getProtagonist();
        boolean pacmanIsVisible = pacman.isInArea(area);
        if (pacmanIsVisible == true){
            direction = this.chasePacman();            
        }else{
            direction = this.getRandomDirection();            
        }               
        return direction;
    }

    public abstract void advanceCycle();

    // ojo: no es random random sino que tiene logica de seguir canales del laberinto.
    // y solo es random en los cruces.
    public abstract Direction getRandomDirection();
    
    public abstract Direction chasePacman();
        

}
