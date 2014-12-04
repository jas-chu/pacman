package com.tdd.model.stageAbstractions;

import com.tdd.controller.controllerAbstractions.PlayerController;
import com.tdd.model.exceptions.BlockedCellException;
import com.tdd.model.exceptions.NoExistingCellException;
import com.tdd.model.exceptions.NoMoreMovementsException;

public abstract class Protagonist extends MovingElement {

    protected Integer score;
    protected boolean onStage;
    protected PlayerController controller;
    protected Direction lastDirection;

    public Protagonist() {
        super(null, null, 1);
        this.score = 0;
        this.onStage = false;
        this.controller = null;
        this.lastDirection = null;
    }

    public synchronized void placeOnStage(Stage givenStage, Position givenPosition) {
        this.stage = givenStage;
        this.setPosition(givenPosition);
        this.onStage = true;
    }

    public synchronized void removeFromStage() {
        this.stage = null;
        this.position = null;
        this.onStage = false;
    }

    public synchronized boolean isOnStage() {
        return this.onStage;
    }

    public abstract void kill();

    public abstract void revive();

    public abstract boolean isAlive();

    public abstract int getLives();

    public synchronized void setController(PlayerController givenController) {
        this.controller = givenController;
    }

    @Override
    protected synchronized void moveOneTime() {

        if (!(this.isOnStage()) || this.controller == null) {
            return;
        }

        try {
            Direction direction = this.controller.getNewDirection();            
            try {
                this.stage.placeElement(direction, this);
            } catch (BlockedCellException | NoExistingCellException error2) {                
                // player hit wall
            }
            this.setSense(direction);
        } catch (NoMoreMovementsException error1) {
            // don't know where to move
        }

    }

    public synchronized Integer getScore() {
        return this.score;
    }
    
    public synchronized Direction getLastDirection(){
        return this.lastDirection;
    }

    public synchronized void awardPoints(int awardingPoints) {
        this.score += awardingPoints;
    }

    // COLLISIONS
    @Override
    public synchronized void collideWithElement(StageElement anotherElement) {
        if (this.isOnStage()) {
            anotherElement.collideWithProtagonist(this);
        }
    }

    @Override
    public synchronized void collideWithProtagonist(Protagonist givenProtagonist) {
        // does nothing, allows functionality extension.
    }

    @Override
    public synchronized void collideWithEnemy(Enemy givenEnemy) {
        if (this.isOnStage()) {
            givenEnemy.collideWithProtagonist(this);
        }
    }

    @Override
    public synchronized void collideWithConsumable(Consumable givenConsumable) {
        if (this.isOnStage()) {
            this.awardPoints(givenConsumable.consume());
        }
    }

}
