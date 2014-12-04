package com.tdd.model.stage;

import com.tdd.model.helpers.XMLConstants;
import com.tdd.model.stageAbstractions.MovingItem;
import com.tdd.model.stageAbstractions.Position;
import com.tdd.model.stageAbstractions.Stage;
import com.tdd.model.strategyFactory.RandomStrategyFactory;

public class Fruit extends MovingItem {

    private long hiddenWaitingCycles;
    private long hiddenCountedCycles;
    private boolean hidden;
    private int hiddenAwardingPoints;

    public Fruit(Stage givenStage, Position givenPosition, int givenAwardingPoints, int givenSpeed, long givenHiddenCycles) {
        super(givenStage, givenPosition, givenAwardingPoints, new RandomStrategyFactory(), givenSpeed);
        this.hiddenWaitingCycles = givenHiddenCycles;
        this.hidden = false;
        this.hiddenAwardingPoints = 0;
    }

    @Override
    public synchronized int consume() {
        if (this.isHidden()) {
            return this.hiddenAwardingPoints;
        }
        this.hide();
		this.changeAndNotify();
        return this.awardingPoints;
    }

    @Override
    public synchronized boolean isConsumed() {
        return this.isHidden();
    }

    @Override
    public synchronized void advanceMovementCycle() {
        super.advanceMovementCycle();
        if (this.isHidden()) {
            (this.hiddenCountedCycles)++;
            if (this.hiddenWaitingCycles == this.hiddenCountedCycles) {
                this.show();
            }
        }
    }

    public synchronized boolean isHidden() {
        return this.hidden;
    }

    public synchronized void show() {
        this.hidden = false;
    }

    public synchronized void hide() {
        this.hidden = true;
        this.hiddenCountedCycles = 0;
    }

    @Override
    public String getMapSerialization() {
        if (this.isHidden()) {
            return super.getMapSerialization();
        }
        return XMLConstants.FRUIT;
    }


}
