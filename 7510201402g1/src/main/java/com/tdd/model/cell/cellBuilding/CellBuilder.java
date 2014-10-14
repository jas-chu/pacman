package com.tdd.model.cell.cellBuilding;

import com.tdd.model.exceptions.NoAvailableFactoryException;
import com.tdd.model.helpers.XMLConstants;
import com.tdd.model.helpers.XMLReader;
import com.tdd.model.stageAbstractions.Cell;
import com.tdd.model.stageAbstractions.Position;
import java.util.HashMap;
import java.util.Map;
import javax.management.AttributeNotFoundException;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class CellBuilder {

    /**
     *
	 * @param nodes
     * @param node
     * @return
     * @throws AttributeNotFoundException
	 * @throws com.tdd.model.exceptions.NoAvailableFactoryException
     */
    public Cell createCell(NodeList nodes, Node node) throws AttributeNotFoundException, NoAvailableFactoryException {
        int cellId = XMLReader.getNodeId(node);
        Position cellPosition = XMLReader.getNodePosition(node);
        Map<String,String> neighboursIds = XMLReader.getNeighboursIds(node);
		
		boolean hasNeighbours = !(neighboursIds.isEmpty());
        Position targetPosition = getTeleportTargetCellPosition(cellPosition, neighboursIds, nodes);
        CellFactorySearcher cellFactory = new CellFactorySearcher();
        return cellFactory.getFactory(hasNeighbours, targetPosition).getCell(cellId, cellPosition);
    }

    /**
     *
     * @param neighboursIds
     * @return
     */
    private Position getTeleportTargetCellPosition(Position cellPosition, Map<String, String> neighboursIds, NodeList nodes) throws AttributeNotFoundException {
        for (Map.Entry<String, String> entrySet : neighboursIds.entrySet()) {
            String idString = entrySet.getValue();
            Integer neighbourId = Integer.getInteger(idString);
			Node neighbourCellNode = XMLReader.getNodeById(nodes, neighbourId);
			Position neighbourPosition = XMLReader.getNodePosition(neighbourCellNode);
			if (!(cellPosition.isNeighbour(neighbourPosition))) return neighbourPosition;
        }
        return null;
    }

}
