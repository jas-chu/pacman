package com.tdd.model.cell.cellBuilding;

import com.tdd.helpers.XMLReader;
import com.tdd.model.stageAbstractions.Cell;
import com.tdd.model.stageAbstractions.Position;
import javax.management.AttributeNotFoundException;
import org.w3c.dom.Node;

public class CellBuilder {

	public Cell createCell(Node node) throws AttributeNotFoundException {
		int cellId = XMLReader.getNodeId(node);
		Position cellPosition = XMLReader.getNodePosition(node);
        String nodeContent = XMLReader.getAttributeValue(node, "contiene");
		
		
        CellFactorySearcher cellFactory = new CellFactorySearcher();
        return cellFactory.getFactory(CellFactorySearcher.CellName.CLEAR).getCell(cellId, cellPosition);
    }

}
