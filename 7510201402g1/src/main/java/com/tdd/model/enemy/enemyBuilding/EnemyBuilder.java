package com.tdd.model.enemy.enemyBuilding;

import com.tdd.model.ghost.StateFactory;
import com.tdd.model.ghost.Strategy;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.Position;
import com.tdd.model.stageAbstractions.Stage;
import com.tdd.model.strategyFactory.StrategyFactorySearcher;

/**
 *
 *
 */
public class EnemyBuilder {
    /**
     * TODO: Esto es horrible - ya estoy quemado para seguir pensando
     * @param stage
     * @param givenPosition
     * @param status
     * @param sense
     * @param personality
     * @return 
     */
    public Enemy createEnemy(Stage stage, Position givenPosition, String status,String sense,String personality) {
        Enemy enemy = null;
        StrategyFactorySearcher strategyFactorySearcher = new StrategyFactorySearcher();
        //Personality o status debería indicar que estrategia usar
        Strategy strategy = strategyFactorySearcher.getFactory(StrategyFactorySearcher.StrategyName.LAZYSTRATEGY).getStrategy(enemy);
        StateFactory stateFactory = new StateFactory(null, 1, 2);
        EnemyFactorySearcher enemyFactory = new EnemyFactorySearcher();
       
        return enemyFactory.getFactory("ghost").getEnemy(stage, givenPosition, stateFactory, strategy);
    }

}
