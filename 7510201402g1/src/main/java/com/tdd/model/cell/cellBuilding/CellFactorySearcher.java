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

    public CellFactorySearcher() {
        this.factorySearcher = new HashMap();
        this.factorySearcher.put(CellName.BLOCKED, new BlockedCellFactory());
        this.factorySearcher.put(CellName.CLEAR, new ClearCellFactory());
        this.factorySearcher.put(CellName.TELEPORT, new TeleportCellFactory());
    }

    public CellFactory getFactory(CellName name) {
        return this.factorySearcher.get(name);
    }

    public CellFactory getFactory(String name) {
        return this.factorySearcher.get(getCellNameToContent(name));
    }

    private CellName getCellNameToContent(String nodeContent) {
        CellName cellName = CellName.CLEAR;
        if (!nodeContent.isEmpty()) {            
            cellName = CellName.BLOCKED;
        }else if (true) {//TODO: Falta evaluar la celda teletransportadora
            
        }
        return cellName;
    }
}
