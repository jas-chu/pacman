package com.tdd.model.cell.cellFactory;

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
}
