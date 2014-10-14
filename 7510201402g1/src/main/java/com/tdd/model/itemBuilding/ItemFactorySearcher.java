package com.tdd.model.itemBuilding;

import com.tdd.model.exceptions.NoAvailableFactoryException;
import com.tdd.model.helpers.XMLConstants;
import java.util.HashMap;
import java.util.Map;

/**
 *
 *
 */
public class ItemFactorySearcher {
	
    private Map<String, ItemFactory> factorySearcher;

    public ItemFactorySearcher() {
        this.factorySearcher = new HashMap();
        this.factorySearcher.put(XMLConstants.DOT, new DotFactory());
        this.factorySearcher.put(XMLConstants.BIG_DOT, new BigDotFactory());
    }

    /**
     *
     * @param name
     * @return
     */
    public ItemFactory getFactory(String name) throws NoAvailableFactoryException {
        if (this.factorySearcher.containsKey(name)) return this.factorySearcher.get(name);
		throw new NoAvailableFactoryException();
    }
}
