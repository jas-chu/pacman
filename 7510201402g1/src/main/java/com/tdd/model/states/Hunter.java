package com.tdd.model.states;

import com.tdd.model.ghost.State;
import com.tdd.model.helpers.XMLConstants;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.StageCharacter;
import java.util.ArrayList;
import java.util.List;

public class Hunter extends State {

    private int angerLevel;
    private List<Long> waitingCycles;

    public Hunter(Enemy givenEnemy, List<Long> angerWaitingCycles) {
        super(givenEnemy);
        this.angerLevel = 0;
        
        this.waitingCycles = new ArrayList<Long>();
        Long accumulated = new Long(0);
        for (int i = 0; i < angerWaitingCycles.size(); ++i) {
            accumulated += angerWaitingCycles.get(i);
            this.waitingCycles.add(accumulated);
        }
    }

    @Override
    public void increaseAnger() {
        if (this.angerLevel < this.waitingCycles.size()) {
            this.angerLevel++;
        }
    }

    @Override
    public void beEaten(StageCharacter p) {
        p.kill();
    }

    public int getAngerLevel() {
        return this.angerLevel;
    }

    @Override
    protected boolean shouldChangeState() {
        if (this.waitingCycles.isEmpty()) {
            return false;
        }
        return (this.countedCycles == this.waitingCycles.get(angerLevel));
    }

    @Override
    protected void changeState() {
        this.increaseAnger();
    }
    @Override
    public String toString(){
        return XMLConstants.HUNTER;
    }
}
