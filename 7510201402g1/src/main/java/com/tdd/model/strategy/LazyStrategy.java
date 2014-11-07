package com.tdd.model.strategy;

import com.tdd.model.stageAbstractions.Strategy;
import com.tdd.model.helpers.XMLConstants;
import com.tdd.model.stageAbstractions.MovedByStrategy;

public class LazyStrategy extends Strategy {

    public LazyStrategy(MovedByStrategy givenElement, int vision) {
        super(givenElement, vision);
    }
    
    @Override
    public String toString(){
        return XMLConstants.LAZY_STRATEGY;
    }
}
