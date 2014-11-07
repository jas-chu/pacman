package com.tdd.model.enemy.enemyBuilding;

import com.tdd.model.states.StateFactory;
import com.tdd.model.stageAbstractions.Strategy;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.Position;
import com.tdd.model.stageAbstractions.Stage;
import com.tdd.model.stageAbstractions.StrategyFactory;


public interface EnemyFactory {
    public Enemy getEnemy(Stage stage, Position givenPosition, StateFactory givenFactory, StrategyFactory givenStrategy);
}
