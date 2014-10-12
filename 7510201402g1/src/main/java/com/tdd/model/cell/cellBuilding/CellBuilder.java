package com.tdd.model.cell.cellBuilding;

import com.tdd.model.helpers.XMLConstants;
import com.tdd.model.helpers.XMLReader;
import com.tdd.model.stageAbstractions.Cell;
import com.tdd.model.stageAbstractions.Position;
import java.util.HashMap;
import java.util.Map;
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
        HashMap<String, String> neighbours = XMLReader.getNeighbours(node);
        boolean isTeleport = testIsTeleportCell(cellPosition, neighbours);
        CellFactorySearcher cellFactory = new CellFactorySearcher();
        Cell cell = cellFactory.getFactory(nodeContent, isTeleport).getCell(cellId, cellPosition);

        return cell;
    }

    /**
     *
     * @param neighbours
     * @return
     */
    private boolean testIsTeleportCell(Position cellPosition, HashMap<String, String> neighbours) {
        boolean condition = false;
        for (Map.Entry<String, String> entrySet : neighbours.entrySet()) {
            String value = entrySet.getValue();
            if (!value.isEmpty()) {
                //Verificar esto
                String row = value.substring(0, 2);
                String column = value.substring(2, 4);
                Position neighborPosition = new Position(Integer.getInteger(row), Integer.getInteger(column));
                if (!cellPosition.isNeighbor(neighborPosition)) {
                    condition = false;
                }
            }
        }
        return condition;
    }

}
