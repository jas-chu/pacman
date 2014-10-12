package com.tdd.model.strategy;

import com.tdd.model.ghost.Strategy;
import com.tdd.model.stage.SquaredArea;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.Position;
import com.tdd.model.stageAbstractions.Protagonist;

public abstract class StrategySearchers extends Strategy {

    protected Position lastPosition = null;

    public StrategySearchers(Enemy givenEnemy, int vision) {
        super(givenEnemy, vision);
    }

    @Override
    public void getPosibleDirections() {        
        this.area = new SquaredArea(this.enemy.getPosition(), this.vision);
        Protagonist pacman = this.enemy.getProtagonist();
        boolean pacmanIsVisible = pacman.isInArea(this.area);
        if (pacmanIsVisible == true) {
            this.lastPosition = pacman.getPosition();
            this.chasePacman(pacman.getPosition());
        } else if (this.lastPosition == null || this.lastPosition == this.enemy.getPosition()) {
            this.lastPosition = null;
            this.getRandomDirection();
        } else {
            this.chasePacman(this.lastPosition);
        }
    }

}
