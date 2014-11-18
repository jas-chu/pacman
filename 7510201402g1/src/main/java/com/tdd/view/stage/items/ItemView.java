package com.tdd.view.stage.items;

import com.tdd.view.abstractions.View;
import com.tdd.view.windowElements.GameContainer;

/**
 *
 *
 */
public abstract class ItemView extends View {

    ItemsViewFactory factory;

    public ItemView(GameContainer container) {
        super(container);
        factory = ItemsViewFactory.getInstance();
    }
}
