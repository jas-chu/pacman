package com.tdd.model.states;

import com.tdd.model.stageAbstractions.State;
import com.tdd.model.helpers.XMLConstants;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.Protagonist;
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
        for (Long theAngerWaitingCycles : angerWaitingCycles) {
            accumulated += theAngerWaitingCycles;
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
    public void beEaten(Protagonist givenProtagonist) {
        givenProtagonist.kill();
    }

    public int getAngerLevel() {
        return this.angerLevel;
    }

    @Override
    protected boolean shouldChangeState() {
        if (this.waitingCycles.isEmpty()) {
            return false;
        }
        if (angerLevel < waitingCycles.size())
			return (this.countedCycles == this.waitingCycles.get(angerLevel));
		return false;
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
