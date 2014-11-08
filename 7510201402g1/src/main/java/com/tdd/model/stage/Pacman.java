package com.tdd.model.stage;

import com.tdd.model.stageAbstractions.Protagonist;


public class Pacman extends Protagonist {

    private boolean alive;

    public Pacman() {
        super();
        this.alive = true;
    }

    @Override
    public void kill() {
        this.alive = false;
    }
	
    @Override
    public void revive() {
        this.alive = true;
        if (this.isOnStage()) this.stage.placeProtagonistAtHome(this);
    }
	
    @Override
    public boolean isAlive() {
        return this.alive;
    }
	
}
