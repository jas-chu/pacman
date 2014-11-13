package com.tdd.model.stage;

import com.tdd.model.stageAbstractions.Protagonist;

public class Pacman extends Protagonist {

    private int lives;

    public Pacman() {
        super();
        this.lives = 3;
    }

    @Override
    public void kill() {
        (this.lives)--;
        this.revive();
    }

    @Override
    public void revive() {
        if (this.lives == 0) {
            return;
        }
        if (this.isOnStage()) {
            this.stage.placeProtagonistAtHome(this);
        }
    }

    @Override
    public boolean isAlive() {
        return (this.lives > 0);
    }

    public int getLives() {
        return this.lives;
    }
    
 

}
