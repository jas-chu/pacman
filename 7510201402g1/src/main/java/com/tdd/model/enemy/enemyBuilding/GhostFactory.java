package com.tdd.model.enemy.enemyBuilding;

import com.tdd.model.stage.Ghost;
import com.tdd.model.states.StateFactory;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.Position;
import com.tdd.model.stageAbstractions.Stage;
import com.tdd.model.strategyFactory.StrategyFactory;

/**
 *
 * 
 */
public class GhostFactory implements EnemyFactory{


    @Override
    public Enemy getEnemy(Stage stage, Position givenPosition, StateFactory givenFactory, StrategyFactory givenStrategy) {
        return new Ghost(stage, givenPosition, givenFactory, givenStrategy);
    }

}
