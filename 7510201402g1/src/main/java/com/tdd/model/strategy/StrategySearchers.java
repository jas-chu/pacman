package com.tdd.model.strategy;

import com.tdd.model.ghost.Strategy;
import com.tdd.model.stage.SquaredArea;
import com.tdd.model.stageAbstractions.Direction;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.Position;
import com.tdd.model.stageAbstractions.Protagonist;

public abstract class StrategySearchers extends Strategy {

    protected Position lastPosition = null;

    public StrategySearchers(Enemy givenEnemy) {
        super(givenEnemy);
    }

    @Override
    public Direction getDirection() {
        Direction direction;
        this.area = new SquaredArea(this.enemy.getPosition(), this.vision);
        Protagonist pacman = this.enemy.getProtagonist();
        boolean pacmanIsVisible = pacman.isInArea(this.area);
        if (pacmanIsVisible == true) {
            this.lastPosition = pacman.getPosition();
            direction = this.chasePacman(pacman.getPosition());
        } else if (this.lastPosition == null || this.lastPosition == this.enemy.getPosition()) {
            this.lastPosition = null;
            direction = this.getRandomDirection();
        } else {
            direction = this.chasePacman(this.lastPosition);
        }
        return direction;
    }

    @Override
    public void advanceCycle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
