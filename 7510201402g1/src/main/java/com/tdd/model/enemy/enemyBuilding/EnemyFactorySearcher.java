package com.tdd.model.enemy.enemyBuilding;

import com.tdd.model.exceptions.NoAvailableFactoryException;
import com.tdd.model.helpers.XMLConstants;
import java.util.HashMap;

/**
 *
 *
 */
public class EnemyFactorySearcher {

    private final HashMap<String, EnemyFactory> factorySearcher;

    public EnemyFactorySearcher() {
        this.factorySearcher = new HashMap<>();
        this.factorySearcher.put(XMLConstants.GHOST, new GhostFactory());
    }
        /**
     *
     * @param name
     * @return
	 * @throws com.tdd.model.exceptions.NoAvailableFactoryException
     */
    public EnemyFactory getFactory(String name) throws NoAvailableFactoryException {
		if (this.factorySearcher.containsKey(name))
			return this.factorySearcher.get(name);
		throw new NoAvailableFactoryException();
    }
}
