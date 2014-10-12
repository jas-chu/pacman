package com.tdd.model.cell.cellBuilding;

import com.tdd.model.helpers.XMLConstants;
import com.tdd.model.helpers.XMLReader;
import com.tdd.model.stageAbstractions.Cell;
import com.tdd.model.stageAbstractions.Position;
import java.util.HashMap;
import javax.management.AttributeNotFoundException;
import org.w3c.dom.Node;

public class CellBuilder {

    /**
     *
     * @param node
     * @return
     * @throws AttributeNotFoundException
     */
    public Cell createCell(Node node) throws AttributeNotFoundException {
        int cellId = XMLReader.getNodeId(node);
        Position cellPosition = XMLReader.getNodePosition(node);
        String nodeContent = XMLReader.getAttributeValue(node, XMLConstants.CONTENT);
        HashMap<String,Integer> neighbours = XMLReader.getNeighbours(node);
        CellFactorySearcher cellFactory = new CellFactorySearcher();
        Cell cell = cellFactory.getFactory(nodeContent).getCell(cellId, cellPosition);
        cell.setNeighbours(neighbours);
        return cell;
    }

    


}
