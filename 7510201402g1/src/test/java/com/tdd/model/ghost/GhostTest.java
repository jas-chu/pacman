package com.tdd.model.ghost;

import com.tdd.model.states.Hunter;
import com.tdd.model.states.Dead;
import com.tdd.model.states.Prey;
import static org.junit.Assert.*;
import org.junit.Test;

public class GhostTest extends GenericGhostTest {
		
    @Test
    public void createAsHunter() {
        assertEquals(Hunter.class, ghost.getState().getClass());
    }

    @Test
    public void kill() {
        ghost.kill();
        assertEquals(Dead.class, ghost.getState().getClass());
    }

    @Test
    public void turnIntoPrey() {
        ghost.turnToPrey();
        assertEquals(Prey.class, ghost.getState().getClass());
    }

    @Test
    public void reviveAsHunter() {
        ghost.kill();
        ghost.revive();
        assertEquals(Hunter.class, ghost.getState().getClass());
    }
}
