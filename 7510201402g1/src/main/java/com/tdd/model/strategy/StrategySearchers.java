package com.tdd.model.strategy;


import com.tdd.model.ghost.Strategy;
import com.tdd.model.stage.SquaredArea;
import com.tdd.model.stageAbstractions.Direction;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.Protagonist;

public abstract class StrategySearchers extends Strategy{

    public StrategySearchers(Enemy givenEnemy) {
        super(givenEnemy);
    }
    
    //TODO completar
    @Override
    public Direction getDirection(){
        Direction direction;
        this.area = new SquaredArea(this.enemy.getPosition(), this.vision);
        Protagonist pacman = this.enemy.getProtagonist();
        boolean pacmanIsVisible = pacman.isInArea(this.area);
        if (pacmanIsVisible == true){ //o ultimaPosicion != posActual.
            direction = this.chasePacman(pacman.getPosition());            
        }else{
            direction = this.getRandomDirection();            
        }               
        return direction;
    }

}
