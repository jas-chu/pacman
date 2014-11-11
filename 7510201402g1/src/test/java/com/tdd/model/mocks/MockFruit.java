package com.tdd.model.mocks;

import com.tdd.model.stageAbstractions.MovingItem;
import com.tdd.model.stageAbstractions.Position;
import com.tdd.model.stageAbstractions.StrategyFactory;

public class MockFruit extends MovingItem{   

    public MockFruit(MockStage givenStage, Position givenPosition, int givenAwardingPoints,
                                    StrategyFactory givenStrategyFactory, int givenSpeed) {
        super(givenStage,givenPosition,givenAwardingPoints,givenStrategyFactory, givenSpeed);
    }


}
