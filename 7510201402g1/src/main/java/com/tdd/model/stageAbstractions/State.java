package com.tdd.model.stageAbstractions;

public abstract class State {

    protected Enemy enemy;
    protected int countedCycles;
	
    public State(Enemy givenEnemy) {
        this.enemy = givenEnemy;
        this.countedCycles = 0;
    }

    public abstract void increaseAnger();

    public abstract void beEaten(Protagonist givenProtagonist);

    //Para que la presa pueda invertir la direccion calculada.
    public Direction getDirection(Direction givenDirection) {
        return givenDirection;
    }

    public void advanceCycle() {
        this.countedCycles++;
        this.testStateChange();
    }

    private void testStateChange() {
        if (this.shouldChangeState()) {
            this.changeState();
        }
    }

    protected abstract boolean shouldChangeState();

    protected abstract void changeState();

    public void collideWithProtagonist(Protagonist givenProtagonist) {
        this.beEaten(givenProtagonist);
    }

}
