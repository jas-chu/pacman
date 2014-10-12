package com.tdd.model.cell.cellBuilding;

import java.util.HashMap;

/**
 *
 *
 */
public class CellFactorySearcher {

    public enum CellName {

        BLOCKED, CLEAR, TELEPORT
    }

    private final HashMap<CellName, CellFactory> factorySearcher;

    /**
     *
     */
    public CellFactorySearcher() {
        this.factorySearcher = new HashMap();
        this.factorySearcher.put(CellName.BLOCKED, new BlockedCellFactory());
        this.factorySearcher.put(CellName.CLEAR, new ClearCellFactory());
        this.factorySearcher.put(CellName.TELEPORT, new TeleportCellFactory());
    }

    /**
     *
     * @param name
     * @param isTeleport
     * @return
     */
    public CellFactory getFactory(String name,boolean isTeleport) {
        return this.factorySearcher.get(getCellNameToContent(name, isTeleport));
    }

    /**
     *
     * @param nodeContent
     * @param neighbours
     * @return
     */
    private CellName getCellNameToContent(String nodeContent,boolean isTeleport) {
        CellName cellName = CellName.CLEAR;
        if (!nodeContent.isEmpty()) {
            cellName = CellName.BLOCKED;
        } else if (isTeleport) {
            cellName = CellName.TELEPORT;
        }
        return cellName;
    }


}
