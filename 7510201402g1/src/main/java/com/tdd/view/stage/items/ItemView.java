package com.tdd.view.stage.items;

import com.tdd.view.abstractions.View;

/**
 *
 *
 */
public abstract class ItemView extends View {

    ItemsViewFactory factory;

    public ItemView() {
        super();
        factory = ItemsViewFactory.getInstance();
    }
}
