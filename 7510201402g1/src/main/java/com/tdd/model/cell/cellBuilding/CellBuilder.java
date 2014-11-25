package com.tdd.model.cell.cellBuilding;

import com.tdd.model.exceptions.NoAvailableFactoryException;
import com.tdd.model.helpers.XMLReader;
import com.tdd.model.stageAbstractions.Cell;
import com.tdd.model.stageAbstractions.Position;
import java.util.Map;
import javax.management.AttributeNotFoundException;
import org.w3c.dom.Node;

public class CellBuilder {

    /**
     *
     * @param node
     * @return
     * @throws AttributeNotFoundException
	 * @throws com.tdd.model.exceptions.NoAvailableFactoryException
     */
    public Cell createCell(Node node) throws AttributeNotFoundException, NoAvailableFactoryException {
        int cellId = XMLReader.getNodeId(node);
        Position cellPosition = XMLReader.getNodePosition(node);
        Map<String,Position> neighbours = XMLReader.getNeighbours(node);
		
		return new Cell(cellId, cellPosition, neighbours);
    }

}
