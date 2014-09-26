package com.tdd.modelo.fantasma;

import com.tdd.model.ghost.Ghost;
import com.tdd.model.stageAbstractions.Position;
import com.tdd.model.states.Hunter;
import com.tdd.model.states.Dead;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class DeadTest {

    private Position position;
    private Ghost ghost;

    public DeadTest() {
    }

    @Before
    public void setUp() {
        position = new Position(0, 0);
        ghost = new Ghost(position);
    }

    @Test
    public void BeEaten() {
        Ghost enemy = new Ghost(position);
        Hunter hunter = new Hunter(enemy);
        ghost.kill();
        hunter.beEaten(ghost);
        assertEquals(Dead.class, ghost.getState().getClass());
    }
}
