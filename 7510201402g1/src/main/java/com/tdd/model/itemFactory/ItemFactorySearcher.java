package com.tdd.model.itemFactory;

import java.util.HashMap;

/**
 *
 *
 */
public class ItemFactorySearcher {

    public enum ItemName {

        DOT, BIG_DOT
    }

    private final HashMap<ItemName, ItemFactory> factorySearcher;

    /**
     *
     */
    public ItemFactorySearcher() {
        this.factorySearcher = new HashMap();
        this.factorySearcher.put(ItemName.DOT, new DotFactory());
        this.factorySearcher.put(ItemName.BIG_DOT, new BigDoyFactory());
    }

    /**
     *
     * @param name
     * @return
     */
    public ItemFactory getFactory(String name) {
        return this.factorySearcher.get(name);
    }
}
