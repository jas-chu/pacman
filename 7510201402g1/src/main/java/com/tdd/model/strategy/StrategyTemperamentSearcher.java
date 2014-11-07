package com.tdd.model.strategy;

import com.tdd.model.helpers.XMLConstants;
import com.tdd.model.stageAbstractions.MovedByStrategy;

public class StrategyTemperamentSearcher extends StrategySearchers {

    private int incrementalVision;
    private final int initialVision;

    public StrategyTemperamentSearcher(MovedByStrategy givenElement, int vision, int incrementalVision) {
        super(givenElement, vision);
        this.initialVision = vision;
        this.incrementalVision = incrementalVision;
    }

    public void increaseVision() {
        this.vision += this.incrementalVision;
    }

    public void restartVision() {
        this.vision = this.initialVision;
    }

    @Override
    public String toString() {
        return XMLConstants.STRATEGY_TEMPERAMENT_SEARCHER;
    }
}
