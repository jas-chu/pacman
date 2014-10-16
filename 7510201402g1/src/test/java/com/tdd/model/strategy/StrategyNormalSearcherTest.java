package com.tdd.model.strategy;

import com.tdd.model.mocks.MockGhost;
import com.tdd.model.stageAbstractions.Direction;
import com.tdd.model.stageAbstractions.Position;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class StrategyNormalSearcherTest {

    private MockGhost ghost;    
    private int vision;
    private StrategyNormalSearcher instance;

    @Before
    public void setUp() {
        this.vision = 10;
        this.ghost = new MockGhost();  
        this.instance = new StrategyNormalSearcher(ghost,vision);
    }

    @Test
    public void GetDirection() {
        this.ghost.getProtagonist().setIsInArea(true);        
        Direction direction = instance.getDirection();
        Position newPosition = direction.getNewPosition(this.ghost.getPosition());
        assertEquals(newPosition.getY(), this.ghost.getPosition().getY());
        assertEquals(newPosition.getX(), this.ghost.getPosition().calculateXAddingValue(1));       
        
        instance.advanceCycle();        
        this.ghost.getProtagonist().setIsInArea(false);        
        Direction anotherDirection = instance.getDirection();
        Position anotherNewPosition = anotherDirection.getNewPosition(this.ghost.getPosition());
        assertEquals(anotherNewPosition.getX(), this.ghost.getPosition().calculateXAddingValue(1));
        assertEquals(anotherNewPosition.getY(), this.ghost.getPosition().getY());        
    }
}
