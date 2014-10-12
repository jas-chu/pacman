package com.tdd.model.ghost;

import com.tdd.model.stage.SquaredArea;
import com.tdd.model.stageAbstractions.Direction;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.Position;
import com.tdd.model.stageAbstractions.Protagonist;
import java.util.ArrayList;

public abstract class Strategy {

    protected Enemy enemy;
    protected int vision;
    protected SquaredArea area;
    protected ArrayList<Direction> direccionesPosibles;
    protected int indiceDirecciones;

    public Strategy(Enemy givenEnemy) {        
        this.enemy = givenEnemy;        
        this.direccionesPosibles = new ArrayList<>();
    }

    public Direction getDirection(){
        if (direccionesPosibles.isEmpty()){
            this.getPosibleDirections();
        }        
        indiceDirecciones++;
        return direccionesPosibles.get(indiceDirecciones-1);        
    }
    
    public void getPosibleDirections(){        
        this.area = new SquaredArea(this.enemy.getPosition(), this.vision);
        Protagonist pacman = this.enemy.getProtagonist();
        boolean pacmanIsVisible = pacman.isInArea(this.area);
        if (pacmanIsVisible == true){
            this.chasePacman(pacman.getPosition());            
        }else{
            this.getRandomDirection();            
        }                   
    }

    //Para distinguir entre ciclo y ciclo.
    public void advanceCycle(){
        this.area = new SquaredArea(this.enemy.getPosition(), this.vision);
        this.direccionesPosibles.clear();
        this.indiceDirecciones = 0; 
    }
    
    //guarda las 4 direcciones posibles segun su prioridad en this.direccionesPosibles
    public void getRandomDirection(){
        throw new UnsupportedOperationException("Not supported yet.");            
    }

    //ir hacia posicion determinada
    //guarda las 4 direcciones posibles segun su prioridad en this.direccionesPosibles
    public void chasePacman(Position givenPosition){
        throw new UnsupportedOperationException("Not supported yet.");
    }        

}
