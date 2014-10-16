package com.tdd.model.strategy;

import com.tdd.model.mocks.MockGhost;
import com.tdd.model.stageAbstractions.Direction;
import com.tdd.model.stageAbstractions.Position;
import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

public class LazyStrategyTest {
    
    private MockGhost ghost;    
    private int vision;
    private LazyStrategy instance;

    @Before
    public void setUp() {
        this.vision = 10;
        this.ghost = new MockGhost();  
        this.instance = new LazyStrategy(ghost,vision);
    }

    @Test
    public void AdvanceCycle() {                
        instance.getDirection();
        instance.advanceCycle();
        assertEquals(instance.getNumberOfPossibleDirections(),0);         
    }

    @Test
    public void GetDirection() {
        this.ghost.getProtagonist().setIsInArea(true);        
        Direction direction = instance.getDirection();
        Position newPosition = direction.getNewPosition(this.ghost.getPosition());
        assertEquals(newPosition.getX(), this.ghost.getPosition().calculateXAddingValue(1));
        assertEquals(newPosition.getY(), this.ghost.getPosition().getY());        
    }

    @Test
    public void ChasePacman() {
        Position position = new Position(0,3);
        this.instance.chasePacman(position);
        assertEquals(this.instance.getNumberOfPossibleDirections(), 4);        
    }

    @Test
    public void GetRandomDirection() {
        this.instance.getRandomDirection();        
        assertEquals(this.instance.getNumberOfPossibleDirections(), 4);                
    }  
    
}
