package com.tdd.model.ghost;

import com.tdd.model.states.Dead;
import com.tdd.model.states.Prey;
import static org.junit.Assert.assertEquals;
import org.junit.Test;

public class PreyTest extends GenericGhostTest {

    @Test
    public void beEaten() {
        Prey prey = this.factory.createPrey(ghost);
        prey.beEaten(anotherGhost);
        assertEquals(Dead.class, ghost.getState().getClass());
    }

}
