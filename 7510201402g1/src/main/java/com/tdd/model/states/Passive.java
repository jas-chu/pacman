package com.tdd.model.states;

import com.tdd.model.ghost.State;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.StageCharacter;
import java.util.Timer;
import java.util.TimerTask;

public abstract class Passive implements State {

    protected Enemy enemy;
    private Timer timer;

    public Passive(Enemy enemy, TimerTask task, int waitingTime) {
        this.enemy = enemy;
        this.timer = new Timer();
        this.timer.schedule(task, waitingTime);
    }

    @Override
    public void increaseAnger() {
	// por el momento no hace nada
        // permite agregar funcionalidad
    }

    @Override
    public abstract void beEaten(StageCharacter p);

}
