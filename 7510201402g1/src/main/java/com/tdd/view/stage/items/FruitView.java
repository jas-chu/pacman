package com.tdd.view.stage.items;

import com.tdd.model.stage.Fruit;
import com.tdd.model.stageAbstractions.MovingItem;
import com.tdd.view.windowElements.GameContainer;
import java.util.Observable;

/**
 *
 *
 */
public class FruitView extends ItemView {

    public FruitView(MovingItem movingItem, GameContainer container) {
        super(container);
        this.setViewPosition(movingItem.getPosition().getX(), movingItem.getPosition().getY());
        this.observable = movingItem;
        this.img = this.factory.getFruitImage();
    }
	
	@Override
	protected void tellContainerIMustBePainted() {
		this.container.mustPaintStableView(this);
	}
	
    @Override
	protected void consumedUpdate(Observable o, Object arg) {
		this.setVisible(false);
	}
	
	@Override
	protected void notConsumedUpdate(Observable o, Object arg) {
		this.setVisible(true);
	}

}
