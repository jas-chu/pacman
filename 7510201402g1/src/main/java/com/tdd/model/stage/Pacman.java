package com.tdd.model.stage;

import com.tdd.model.exceptions.BlockedCellException;
import com.tdd.model.stageAbstractions.Direction;
import com.tdd.model.stageAbstractions.Position;
import com.tdd.model.stageAbstractions.Protagonist;
import com.tdd.model.stageAbstractions.Stage;

public class Pacman extends Protagonist {

    private boolean alive;
    private Direction sense;

    public Pacman(Stage givenStage, Position givenPosition) {
        super(givenStage, givenPosition);
        this.alive = true;
    }

    @Override
    public void kill() {
        this.alive = false;
    }

    @Override
    public void revive() {
        this.alive = true;
        this.stage.placeProtagonistAtHome(this);
    }

    @Override
    public boolean isAlive() {
        return this.alive;
    }

    @Override
    public void move(Direction dir) {
        this.removeTeleportedState();
        Position nextPosition = dir.getNewPosition(this.position);
        try {
            this.stage.placeElement(nextPosition, this);
        } catch (BlockedCellException error) {
            // player hit wall
        }
    }

    @Override
    public void setSense(Direction sense) {
        this.sense = sense;
    }

    @Override
    public Direction getSense() {
        return this.sense;
    }
    
    
}
