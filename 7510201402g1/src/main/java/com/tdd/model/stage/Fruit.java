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

    public Fruit(Stage givenStage, Position givenPosition, int givenAwardingPoints, int givenSpeed, long givenHiddenCycles) {
        super(givenStage, givenPosition, givenAwardingPoints, new RandomStrategyFactory(), givenSpeed);
        this.hiddenWaitingCycles = givenHiddenCycles;
        this.hidden = false;
    }

    @Override
    public int consume() {
        System.out.println("FRUIT CONSUME");
        if (this.isHidden()) {
            return 0;
        }
        this.hide();        
        return this.awardingPoints;
    }

    @Override
    public boolean isConsumed() {
        return this.isHidden();
    }

    @Override
    public void advanceMovementCycle() {        
        super.advanceMovementCycle();
        if (this.isHidden()) {
            (this.hiddenCountedCycles)++;
            if (this.hiddenWaitingCycles == this.hiddenCountedCycles) {
                this.show();
            }
        }
    }

    public boolean isHidden() {
        return this.hidden;
    }

    public void show() {
        this.hidden = false;
    }

    public void hide() {
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
