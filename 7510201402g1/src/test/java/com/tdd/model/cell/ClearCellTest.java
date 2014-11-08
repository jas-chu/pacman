package com.tdd.model.cell;

import com.tdd.model.helpers.XMLConstants;
import com.tdd.model.mocks.MockStaticItem;
import java.util.HashMap;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;

public class ClearCellTest extends CellTest {
    
    @Before
	@Override
	public void setUp() {
		super.setUp();
		HashMap<String,String> neighbours = new HashMap<String,String>();
		neighbours.put(XMLConstants.DIRECTION_RIGHT, (new Integer(this.cellId + 1)).toString());
		this.cell = new ClearCell(this.cellId, this.position, neighbours);
	}
    
	@Test
	@Override
    public void getContent() {
        assertEquals(this.cell.getContent(),"");
		
		MockStaticItem item = new MockStaticItem();
		this.cell.placeElement(item);
		assertEquals(item.getMapSerialization(), this.cell.getContent());
    }
	
}
