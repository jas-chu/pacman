package com.tdd.model.helpers;

import com.tdd.model.stageAbstractions.Position;
import javax.management.AttributeNotFoundException;
import static org.junit.Assert.assertEquals;
import org.junit.Before;
import org.junit.Test;
import org.w3c.dom.NodeList;

public class LabyrinthLoaderTest extends ReadingSetUpTest {
	
	private LabyrinthLoader loader;
	
    @Before
	@Override
    public void setUp() {
		super.setUp();
		this.loader = new LabyrinthLoader(this.XMLpath);
    }
	
    @Test
    public void getLabyrinthWidth() throws AttributeNotFoundException {
        Integer width = this.loader.getLabyrinthWidth();
		assert(width == 19);
    }

    @Test
    public void getLabyrinthHeight() throws AttributeNotFoundException {
        Integer height = this.loader.getLabyrinthHeight();
		assert(height == 19);
    }

    @Test
    public void getPacmanStartPosition() throws AttributeNotFoundException {
        Position expectedPosition = new Position(8,4);
        Position position = this.loader.getPacmanStartPosition();
        assert(expectedPosition.equals(position));
    }

    @Test
    public void getGhostStartPosition() throws AttributeNotFoundException {
        Position expectedPosition = new Position(9,8);
        Position position = this.loader.getGhostStartPosition();
        assert(expectedPosition.equals(position));
    }
	
	@Test
    public void getNodes() {
		NodeList nodes = this.loader.getNodes();
		assert(nodes != null);
		assertEquals(nodes.item(0).getNodeName(),this.constants.getConstantTranslation(XMLConstants.NODE));
    }
	
    @Test
    public void getNodeWidth() throws AttributeNotFoundException {
		Integer width = this.loader.getNodeWidth();
		assert(width == 45);
    }

    @Test
    public void getNodeHeight() throws AttributeNotFoundException {
		Integer height = this.loader.getNodeHeight();
		assert(height == 45);
    }

}