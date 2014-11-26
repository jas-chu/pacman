package com.tdd.view.stage.protagonist;

import com.tdd.model.stageAbstractions.Position;
import com.tdd.model.stageAbstractions.Protagonist;
import com.tdd.view.abstractions.View;
import com.tdd.view.manager.ViewManager;
import com.tdd.view.windowElements.GameContainer;
import java.util.Observable;

/**
 *
 *
 */
public class ProtagonistView extends View {

    private ProtagonistViewFactory factory;

    public ProtagonistView(Protagonist protagonist, GameContainer container) {
        super(container);
        this.setViewPosition(protagonist.getPosition().getX(), protagonist.getPosition().getY());
        this.observable = protagonist;
        this.factory = ProtagonistViewFactory.getInstance();
        this.img = this.factory.getDefault();
    }

    @Override
    public void update(Observable o, Object arg) {
        Protagonist protagonist = (Protagonist) o;
		this.img = this.factory.getImage(protagonist.getSense().toString());
		super.update(o, arg);
    }
	
	@Override
	protected void otherUpdates() {
		this.audio.playSound();
	}

}
