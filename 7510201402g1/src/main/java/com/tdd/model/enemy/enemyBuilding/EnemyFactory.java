package com.tdd.model.enemy.enemyBuilding;

import com.tdd.model.ghost.StateFactory;
import com.tdd.model.ghost.Strategy;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.Position;
import com.tdd.model.stageAbstractions.Stage;


public interface EnemyFactory {
    public Enemy getEnemy(Stage stage, Position givenPosition, StateFactory givenFactory, Strategy givenStrategy);
}
