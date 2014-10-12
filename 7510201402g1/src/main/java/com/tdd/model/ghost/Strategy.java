package com.tdd.model.ghost;

import com.tdd.model.direction.*;
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

    public Strategy(Enemy givenEnemy, int vision) {        
        this.enemy = givenEnemy;        
        this.vision = vision;
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
        //hay que guardar direccion anterior para seguir siempre la misma direccion al 
        //entrar a un canal.
        throw new UnsupportedOperationException("Not supported yet.");            
    }

    public void chasePacman(Position givenPosition){
        ArrayList<Direction> directions = this.getAllDirections();
        ArrayList<Double> distances = this.getAllDistances(givenPosition);
        while(!distances.isEmpty()){
            int indexMin = 0;
            double min = distances.get(0);
            for (int x = 0; x < distances.size(); x++){
                if(distances.get(x) < min){
                    min = distances.get(x);
                    indexMin = x;
                }
            }
            this.direccionesPosibles.add(directions.remove(indexMin));
            distances.remove(indexMin);
        }
    }   
    
    private ArrayList<Direction> getAllDirections(){
        ArrayList<Direction> directions = new ArrayList<>();        
        directions.add(new DirectionLeft());
        directions.add(new DirectionRight());
        directions.add(new DirectionUp());
        directions.add(new DirectionDown());
        return directions;
    }
    
    private ArrayList<Double> getAllDistances(Position givenPosition){
        Position left = givenPosition.createPositionSubstractingX(this.enemy.getPosition().getX());       
        Position right = givenPosition.createPositionAddingX(this.enemy.getPosition().getX());
        Position up = givenPosition.createPositionAddingY(this.enemy.getPosition().getY());
        Position down = givenPosition.createPositionSubstractingY(this.enemy.getPosition().getY());                
        ArrayList<Double> distances = new ArrayList<>();
        distances.add(givenPosition.getDistance(left));
        distances.add(givenPosition.getDistance(right));
        distances.add(givenPosition.getDistance(up));
        distances.add(givenPosition.getDistance(down));     
        return distances;
    }

}
