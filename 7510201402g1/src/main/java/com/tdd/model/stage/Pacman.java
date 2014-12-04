package com.tdd.model.stage;

import com.tdd.model.stageAbstractions.Protagonist;

public class Pacman extends Protagonist {

    private int lives;

    public Pacman() {
        super();
        this.lives = 3;
    }

    @Override
    public synchronized void kill() {
        (this.lives)--;
        this.revive();
    }

    @Override
    public synchronized void revive() {
        if (this.lives <= 0) {
            return;
        }
        if (this.isOnStage()) {
            this.stage.placeProtagonistAtHome(this);
        }
    }

    @Override
    public synchronized boolean isAlive() {
        return (this.lives > 0);
    }

	@Override
    public synchronized int getLives() {
        return this.lives;
    }
    
 

}
