package com.tdd.view.stage.items;

import com.tdd.model.stageAbstractions.Consumable;
import com.tdd.view.abstractions.View;
import com.tdd.view.manager.ViewManager;
import com.tdd.view.windowElements.GameContainer;
import java.util.Observable;

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
	
	@Override
    public void update(Observable o, Object arg) {
		Consumable item = (Consumable) o;
		if (item.isConsumed()) {
			ViewManager manager = ViewManager.getInstance();
			manager.removeVolatileView(this);
			o.deleteObserver(this);
		}
		super.update(o, arg);
    }
}
