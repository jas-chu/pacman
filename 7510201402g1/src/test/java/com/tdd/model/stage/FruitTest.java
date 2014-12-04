package com.tdd.model.stage;

import com.tdd.model.helpers.XMLConstants;
import com.tdd.model.stageAbstractions.StageElement;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;
import org.junit.Before;
import org.junit.Test;

public class FruitTest extends StageElementTest {

    private Fruit fruit;
    private final int awardingPoints = 3;
    private final int speed = 1;
    private final int hiddenCycles = 5 ;

    @Before
	@Override
    public void setUp() {
		super.setUp();
        this.fruit = (Fruit) this.element;
    }
	
	@Override
	protected StageElement createElement() {
		return new Fruit(stage,position,awardingPoints,speed, hiddenCycles);
	}
	
    @Test
    public void initTest(){
        assertFalse(this.fruit.isHidden());
    }
    
    @Test
    public void hideTest() {        
        this.fruit.hide();
        assertTrue(this.fruit.isHidden());
    }
    
    @Test
    public void showTest() {                
        this.fruit.show();
        assertFalse(this.fruit.isHidden());
    }
        
    @Test
    public void consumeNotHiddenTest() {        
        assertEquals(this.fruit.consume(),this.awardingPoints);        
    }
    
    @Test
    public void consumeHiddenTest() {  
        this.fruit.hide();
        assertEquals(this.fruit.consume(),0);        
    }
    
    @Test
    public void hiddenSerializationTest(){
        this.fruit.hide();
        assertEquals(this.fruit.getMapSerialization(),"");      
    }
    
    @Test
    public void notHiddenSerializationTest(){
        assertEquals(this.fruit.getMapSerialization(),XMLConstants.FRUIT);
    }
    
}
