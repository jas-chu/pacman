package com.tdd.model.ghost;

import com.tdd.model.stageAbstractions.Direction;
import com.tdd.model.stageAbstractions.StageCharacter;

public interface State {

    public void increaseAnger();

    public void beEaten(StageCharacter p);

    public Direction getDirection(Direction givenDirection);

}
