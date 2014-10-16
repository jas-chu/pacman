package com.tdd.model.cell;

import com.tdd.model.exceptions.BlockedCellException;
import java.util.HashMap;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Before;

public class BlockedCellTest extends CellTest {
    
    @Before
	@Override
	public void setUp() {
		super.setUp();
		this.cell = new BlockedCell(this.cellId, this.position, new HashMap<String,String>());
	}
	
    @Test
	@Override
    public void testPlaceElement() {
		try {
			this.cell.testPlaceElement();
			fail();
		} catch (BlockedCellException ex) {
			assert(true);
		}
    }

    @Test
	@Override
    public void placeElement() {
        this.cell.placeElement(this.protagonist);
		assertTrue(this.protagonist.noMethodWasCalled());
		assertTrue(this.cell.isEmpty());
    }

    @Test
	@Override
    public void removeElement() {
        this.cell.removeElement(this.protagonist);
		assertTrue(this.protagonist.noMethodWasCalled());
    }
    
}
