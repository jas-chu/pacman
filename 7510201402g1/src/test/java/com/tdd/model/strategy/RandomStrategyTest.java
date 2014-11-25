package com.tdd.model.strategy;

import com.tdd.model.mocks.MockFruit;
import com.tdd.model.mocks.MockStage;
import com.tdd.model.stageAbstractions.Position;
import com.tdd.model.strategyFactory.RandomStrategyFactory;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class RandomStrategyTest {   
    
    private MockFruit fruit;    
    private RandomStrategy instance;    
    private Position position;
    private MockStage stage;
    private RandomStrategyFactory factory;
    private final int awardingPoints = 3;
    private final int speed = 1;

    @Before
    public void setUp() {
        this.factory = new RandomStrategyFactory();
        this.position = new Position(0, 0);
        this.stage = new MockStage();        
        this.fruit = new MockFruit(stage,position,awardingPoints,factory,speed);       
        this.instance = new RandomStrategy(this.fruit);
    }

    @Test
    public void init() {                
        assertEquals(this.instance.getNumberOfPossibleDirections(),0);        
    }

    @Test
    public void getDirection() {
        this.instance.getDirection();
        assertEquals(2, this.instance.getNumberOfPossibleDirections());
    }
    
    @Test
    public void GetRandomDirection() {
		this.instance.getRandomDirection();        
        assertEquals(2, this.instance.getNumberOfPossibleDirections());
    }  
    

}
