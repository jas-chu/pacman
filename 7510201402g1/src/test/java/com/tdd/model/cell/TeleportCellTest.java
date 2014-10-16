package com.tdd.model.cell;

import com.tdd.model.helpers.XMLConstants;
import com.tdd.model.stageAbstractions.Position;
import java.util.HashMap;
import org.junit.Test;
import org.junit.Before;

public class TeleportCellTest extends CellTest {
	
    @Before
	@Override
	public void setUp() {
		super.setUp();
		HashMap<String,String> neighbours = new HashMap<String,String>();
		neighbours.put(XMLConstants.DIRECTION_RIGHT, (new Integer(this.cellId + 2)).toString());
		this.cell = new TeleportCell(this.cellId, this.position, neighbours, new Position(1,9));
	}
    
	@Test
	@Override
    public void placeElement() {
        this.cell.placeElement(this.protagonist);
		assert(this.protagonist.teleportMethodCalled);
    }
	
}
