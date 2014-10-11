package com.tdd.model.ghost;

import com.tdd.model.stage.SquaredArea;
import com.tdd.model.stageAbstractions.Direction;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.Position;
import com.tdd.model.stageAbstractions.Protagonist;

public abstract class Strategy {

    protected Enemy enemy;
    protected int vision;
    protected SquaredArea area;

    public Strategy(Enemy givenEnemy) {
        this.enemy = givenEnemy;        
    }

    public Direction getDirection(){
        Direction direction;
        this.area = new SquaredArea(this.enemy.getPosition(), this.vision);
        Protagonist pacman = this.enemy.getProtagonist();
        boolean pacmanIsVisible = pacman.isInArea(this.area);
        if (pacmanIsVisible == true){
            direction = this.chasePacman(pacman.getPosition());            
        }else{
            direction = this.getRandomDirection();            
        }               
        return direction;
    }

    // centra el area con respecto a la position del enemy y de ser necesario, limpiá el
    // "buffer de direcciones alternativas" de ese ciclo
    public void advanceCycle(){
        
    }

    // ojo: no es random random sino que tiene logica de seguir canales del laberinto.
    // y solo es random en los cruces.
    public Direction getRandomDirection(){
        throw new UnsupportedOperationException("Not supported yet.");            
    }

    //ir hacia posicion determinada
    public Direction chasePacman(Position givenPosition){
        throw new UnsupportedOperationException("Not supported yet.");
    }        

}
