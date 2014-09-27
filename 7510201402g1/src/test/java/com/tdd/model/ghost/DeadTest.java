package com.tdd.model.ghost;

import com.tdd.model.states.Dead;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class DeadTest extends GenericGhostTest {

	@Test
    public void beEaten() {
        Dead dead = this.factory.createDead(ghost);
        dead.beEaten(anotherGhost);
        assertEquals(Dead.class, ghost.getState().getClass());
    }
}
