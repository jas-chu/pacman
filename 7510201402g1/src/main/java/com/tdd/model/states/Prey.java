package com.tdd.model.states;

import com.tdd.model.helpers.XMLConstants;
import com.tdd.model.stageAbstractions.Direction;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.Protagonist;

public class Prey extends Passive {

    public Prey(Enemy enemy, int preyCycles) {
        super(enemy, preyCycles);
    }

    @Override
    public void beEaten(Protagonist givenProtagonist) {
        this.enemy.kill();
        int points = this.enemy.getAwardingPoints();
        givenProtagonist.awardPoints(points);
    }

    @Override
    public Direction getDirection(Direction givenDirection) {
        return givenDirection.invert();
    }

    @Override
    public String toString() {
        return XMLConstants.PREY;
    }
}
