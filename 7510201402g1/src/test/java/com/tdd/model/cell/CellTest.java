package com.tdd.model.cell;

import com.tdd.model.exceptions.BlockedCellException;
import com.tdd.model.mocks.MockProtagonist;
import com.tdd.model.stageAbstractions.Cell;
import com.tdd.model.stageAbstractions.Position;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public abstract class CellTest {
	
	protected int cellId;
	protected Position position;
	protected Cell cell;
	protected MockProtagonist protagonist;

    @Before
	public void setUp() {
		this.cellId = 103;
		this.position = new Position(7, 3);
		this.protagonist = new MockProtagonist();
	}
	
	@Test
	public void getId() {
        assert(this.cell.getId() == this.cellId);
    }
	
	@Test
    public void getRow() {
        assert(this.position.getY() == this.cell.getRow());
    }
	
	@Test
    public void getColumn() {
        assert(this.position.getX() == this.cell.getColumn());
    }
	
	@Test
    public void getPosition() {
        assert(this.position.equals(this.cell.getPosition()));
    }
	
	@Test
    public void testPlaceElement() {
		try {
			this.cell.testPlaceElement();
			assert(true);
		} catch (BlockedCellException ex) {
			fail();
		}
    }

    @Test
    public void placeElement() {
		this.cell.placeElement(this.protagonist);
		assertTrue(protagonist.getPosition().equals(this.cell.getPosition()));
		assertFalse(this.cell.isEmpty());
    }

    @Test
    public void removeElement() {
		this.cell.placeElement(protagonist);
        this.cell.removeElement(this.protagonist);
		assertTrue(this.cell.isEmpty());
    }
	
	@Test
    public void getContent() {
        assertEquals(this.cell.getContent(),"");
    }
	
}