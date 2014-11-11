package com.tdd.model.stage;

import com.tdd.model.helpers.XMLConstants;
import com.tdd.model.mocks.MockStage;
import com.tdd.model.stageAbstractions.Position;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class FruitTest {

    private Fruit fruit;
    private Position position;
    private MockStage stage;
    private final int awardingPoints = 3;
    private final int speed = 1;
    private final int hiddenCycles = 5 ;

    @Before
    public void setUp() {
        this.position = new Position(0, 0);
        this.stage = new MockStage();        
        this.fruit = new Fruit(stage,position,awardingPoints,speed, hiddenCycles);       
    }

    @Test
    public void init(){
        assertFalse(this.fruit.isHidden());
    }
    
    @Test
    public void hide() {        
        this.fruit.hide();
        assertTrue(this.fruit.isHidden());
    }
    
    @Test
    public void show() {                
        this.fruit.show();
        assertFalse(this.fruit.isHidden());
    }
        
    @Test
    public void consumeNotHidden() {        
        assertEquals(this.fruit.consume(),this.awardingPoints);        
    }
    
    @Test
    public void consumeHidden() {  
        this.fruit.hide();
        assertEquals(this.fruit.consume(),0);        
    }
    
    @Test
    public void hiddenSerialization(){
        this.fruit.hide();
        assertEquals(this.fruit.getMapSerialization(),"");      
    }
    
    @Test
    public void notHiddenSerialization(){
        assertEquals(this.fruit.getMapSerialization(),XMLConstants.FRUIT);
    }
    
}
