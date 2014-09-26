package com.tdd.model.ghost;

import com.tdd.model.stageAbstractions.Position;
import com.tdd.model.ghost.Ghost;
import com.tdd.model.states.Dead;
import com.tdd.model.states.Prey;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class PreyTest {

    private Position position;
    private Ghost ghost;

    public PreyTest() {
    }

    @Before
    public void setUp() {
        position = new Position(0, 0);
        ghost = new Ghost(position);
    }

    @Test
    public void SerComido() {
        Prey prey = new Prey(ghost);
        prey.beEaten(ghost);
        assertEquals(Dead.class, ghost.getState().getClass());
    }

}
