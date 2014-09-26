package com.tdd.model.stageAbstractions;

import java.util.TimerTask;

public class Revividor extends TimerTask {

    private StageCharacter personaje;

    public Revividor(StageCharacter p) {
        super();
        this.personaje = p;
    }

    @Override
    public void run() {
        this.personaje.revive();
    }

}
