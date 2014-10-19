package com.tdd.model.stageAbstractions;

public abstract class StageCharacter extends StageElement {

    public StageCharacter(Stage givenStage, Position givenPosition) {
        super(givenStage, givenPosition);
    }

    public abstract void kill();

    public abstract void revive();

    public abstract void setSense(Direction sense);
    
    public abstract Direction getSense();

    @Override
    public String getMapSerialization() {
        return "";
    }

}
