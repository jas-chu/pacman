package com.tdd.model.cell.cellBuilding;

import com.tdd.model.exceptions.NotMyJobException;
import com.tdd.model.exceptions.NoAvailableFactoryException;
import com.tdd.model.stageAbstractions.Position;
import java.util.ArrayList;
import java.util.List;

public class CellFactorySearcher {

    private List<CellFactory> availableFactories;

    public CellFactorySearcher() {
        this.availableFactories = new ArrayList<CellFactory>();
        this.availableFactories.add(new BlockedCellFactory());
        this.availableFactories.add(new ClearCellFactory());
        this.availableFactories.add(new TeleportCellFactory());
    }

    /**
     *
	 * @param hasNeighbours
	 * @param teleportTarget may be null
     * @return
     */
    public CellFactory getFactory(boolean hasNeighbours, Position teleportTarget) throws NoAvailableFactoryException {
		for (CellFactory factory : this.availableFactories) {
			try {
				factory.setUp(hasNeighbours, teleportTarget);
				return factory;
			} catch (NotMyJobException e) {
				// move on to next factory
			}
		}
        throw new NoAvailableFactoryException();
    }

}
