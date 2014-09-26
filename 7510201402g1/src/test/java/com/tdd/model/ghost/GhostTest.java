package com.tdd.model.ghost;

import com.tdd.model.ghost.Ghost;
import com.tdd.model.stageAbstractions.Position;
import com.tdd.model.states.Hunter;
import com.tdd.model.states.Dead;
import com.tdd.model.states.Prey;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class GhostTest {

    private Position position;
    private Ghost ghost;

    public GhostTest() {
    }

    @Before
    public void setUp() {
        position = new Position(0, 0);
        ghost = new Ghost(position);
    }

    @Test
    public void CreateAsHunter() {
        assertEquals(Hunter.class, ghost.getState().getClass());
    }

    @Test
    public void Kill() {
        ghost.kill();
        assertEquals(Dead.class, ghost.getState().getClass());
    }

    @Test
    public void TurnIntoPray() {
        ghost.turnToPrey();
        assertEquals(Prey.class, ghost.getState().getClass());
    }

    @Test
    public void ReviveAsHunter() {
        ghost.kill();
        ghost.revive();
        assertEquals(Hunter.class, ghost.getState().getClass());
    }
}
