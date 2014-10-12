package com.tdd.model.strategy;

import com.tdd.model.stageAbstractions.Enemy;

public class StrategyTemperamentSearcher extends StrategySearchers {
    private int incrementalVision;
    private final int initialVision;

    public StrategyTemperamentSearcher(Enemy givenEnemy, int vision) {
        super(givenEnemy, vision);
        this.initialVision = vision;
    }  
    
    public void increaseVision(){
        this.vision += this.incrementalVision;        
    }
    
    public void restartVision(){
        this.vision = this.initialVision;        
    }
}
