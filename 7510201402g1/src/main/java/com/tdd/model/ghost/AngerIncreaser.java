package com.tdd.model.ghost;

import java.util.TimerTask;

public class AngerIncreaser extends TimerTask {

    private State state;

    public AngerIncreaser(State e) {
        super();
        this.state = e;
    }

    @Override
    public void run() {
        this.state.increaseAnger();
    }

}
