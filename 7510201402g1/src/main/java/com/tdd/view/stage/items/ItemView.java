package com.tdd.view.stage.items;

import com.tdd.model.stageAbstractions.Consumable;
import com.tdd.view.abstractions.View;
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
	protected void tellContainerIMustBePainted() {
		this.container.mustPaintVolatileView(this);
	}
	
	@Override
    public void update(Observable o, Object arg) {
		Consumable item = (Consumable) o;
		if (item.isConsumed()) {
			this.setVisible(false);
			o.deleteObserver(this);
		}
		super.update(o, arg);
    }
}
