package com.tdd.model.strategy;

import com.tdd.model.stageAbstractions.Enemy;

public class StrategyTemperamentSearcher extends StrategySearchers {

    public StrategyTemperamentSearcher(Enemy givenEnemy) {
        super(givenEnemy);
    }

    @Override
    public void advanceCycle() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void incrementarVision(){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void reiniciarVision(){
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
