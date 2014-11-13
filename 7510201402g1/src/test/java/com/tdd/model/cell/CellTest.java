package com.tdd.model.cell;

import com.tdd.model.direction.DirectionRight;
import com.tdd.model.exceptions.BlockedCellException;
import com.tdd.model.helpers.XMLConstants;
import com.tdd.model.mocks.MockProtagonist;
import com.tdd.model.mocks.MockStaticItem;
import com.tdd.model.stageAbstractions.Cell;
import com.tdd.model.stageAbstractions.Position;
import java.util.HashMap;
import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public abstract class CellTest {
	
	private int cellId;
	private Position position;
	private Cell cell;
	private MockProtagonist protagonist;

    @Before
	public void setUp() {
		this.cellId = 103;
		this.position = new Position(7, 3);
		this.protagonist = new MockProtagonist();
		HashMap<String,Position> neighbours = new HashMap<String,Position>();
		neighbours.put(XMLConstants.DIRECTION_RIGHT, this.position.createPositionAddingX(1));
		this.cell = new Cell(this.cellId, this.position, neighbours);
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
    public void getTargetPosition() {
		try {
			this.cell.getTargetPosition(new DirectionRight());
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
		
		MockStaticItem item = new MockStaticItem();
		this.cell.placeElement(item);
		assertEquals(item.getMapSerialization(), this.cell.getContent());
    }
	
}