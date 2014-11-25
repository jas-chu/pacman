package com.tdd.view.stage.protagonist;

import com.tdd.model.stageAbstractions.Position;
import com.tdd.model.stageAbstractions.Protagonist;
import com.tdd.view.abstractions.View;
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
        Protagonist protagonist = (Protagonist) observable;
        this.img = this.factory.getImage(protagonist.getSense().toString());
        //Si me movi que reproduzca el sonido
        
        if (!protagonist.getPosition().equals(new Position(this.x, this.y))){
            this.audio.playSound();
        }
        this.setViewPosition(protagonist.getPosition().getX(), protagonist.getPosition().getY());
    }

}
