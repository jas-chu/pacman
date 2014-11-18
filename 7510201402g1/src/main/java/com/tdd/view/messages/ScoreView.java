package com.tdd.view.messages;

import com.tdd.model.stageAbstractions.Protagonist;
import java.util.Observable;

/**
 *
 *
 */
public class ScoreView extends DinamycMessage {

    private int score;

    public ScoreView() {
        super("");

        this.updateScore(0);
    }

    @Override
    public void update(Observable o, Object arg) {
        Protagonist protagonist = (Protagonist) o;
        this.updateScore(protagonist.getScore());
    }

    public void updateScore(int score){
        this.score = score;
         this.setText("Score: "+this.score);
    }
}
