package com.tdd.model.strategy;

import com.tdd.model.stageAbstractions.Strategy;
import com.tdd.model.stage.SquaredArea;
import com.tdd.model.stageAbstractions.MovedByStrategy;
import com.tdd.model.stageAbstractions.Position;
import com.tdd.model.stageAbstractions.Protagonist;

public abstract class StrategySearchers extends Strategy {

    protected Position lastPosition = null;

    public StrategySearchers(MovedByStrategy givenElement, int vision) {
        super(givenElement, vision);
    }

    @Override
    public void getPossibleDirections() {        
        this.area = new SquaredArea(this.element.getPosition(), this.vision);
        Protagonist pacman = this.element.getProtagonist();
		if (pacman == null) return;
        boolean pacmanIsVisible = pacman.isInArea(this.area);
        if (pacmanIsVisible == true) {
            this.lastPosition = pacman.getPosition();
            this.chasePacman(pacman.getPosition());
        } else if (this.lastPosition == null || this.lastPosition == this.element.getPosition()) {
            this.lastPosition = null;
            this.getRandomDirection();
        } else {
            this.chasePacman(this.lastPosition);
        }
    }

}
