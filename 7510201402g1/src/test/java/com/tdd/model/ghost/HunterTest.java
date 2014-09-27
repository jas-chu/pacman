package com.tdd.model.ghost;

import com.tdd.model.states.Hunter;
import static org.junit.Assert.*;
import org.junit.Test;

public class HunterTest extends GenericGhostTest {

    @Test
    public void angerLevel() {
        Hunter hunter = this.factory.createHunter(ghost);
        assertEquals(hunter.getAngerLevel(), 0);
        hunter.increaseAnger();
        assertEquals(hunter.getAngerLevel(), 1);
    }

    @Test
    public void beEaten() {
        Hunter hunter = this.factory.createHunter(ghost);
        hunter.beEaten(anotherGhost);
        assertEquals(Hunter.class, ghost.getState().getClass());
    }
}
