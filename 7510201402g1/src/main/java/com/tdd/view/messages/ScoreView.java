package com.tdd.view.messages;

import com.tdd.model.stageAbstractions.Protagonist;
import java.util.Observable;

/**
 *
 *
 */
public class ScoreView extends DinamycMessage {


    public ScoreView() {
        this.updateScore(0,0);
    }

    @Override
    public void update(Observable o, Object arg) {
        Protagonist protagonist = (Protagonist) o;
        this.updateScore(protagonist.getScore(),protagonist.getLives());
    }

    public void updateScore(int score,int lives){

        this.setText("Score: "+score+" Lives:"+ lives);
    }
}
