package com.tdd.model.states;

import com.tdd.model.configuration.Configuration;
import com.tdd.model.stageAbstractions.Direction;
import com.tdd.model.ghost.State;
import com.tdd.model.ghost.AngerIncreaser;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.StageCharacter;
import java.util.ArrayList;
import java.util.List;
import java.util.Timer;

public class Hunter implements State {

    private Enemy enemy;
    private Timer timer;
    private int angerLevel;
    private int numberOfAngerLevels;
    private List<Long> waitingTimes;

    public Hunter(Enemy e) {
        this.setHunterConfiguration();

        this.enemy = e;
        this.angerLevel = 0;

        this.timer = new Timer();
        int accumulatedTime = 0;
        for (Long time : waitingTimes) {
            accumulatedTime += time;
            this.timer.schedule(new AngerIncreaser(this), accumulatedTime);
        }
    }

    @Override
    public void increaseAnger() {
        if (this.angerLevel < this.numberOfAngerLevels) {
            this.angerLevel++;
        }
    }

    @Override
    public void beEaten(StageCharacter p) {
        p.kill();
    }

    private void setHunterConfiguration() {
        this.waitingTimes = new ArrayList<>();
        this.numberOfAngerLevels = 3;
        Configuration configuration = Configuration.getConfiguracion();
        for (Long tiempo : configuration.getTiemposCazador()) {
            waitingTimes.add(tiempo);
        }
    }

    public int getAngerLevel() {
        return this.angerLevel;
    }

    @Override
    public Direction getDirection(Direction givenDirection) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
