package com.tdd.model.enemy.enemyBuilding;

import com.tdd.application.gameAbstractions.GameConfigurations;
import com.tdd.model.exceptions.NoAvailableFactoryException;
import com.tdd.model.ghost.StateFactory;
import com.tdd.model.ghost.Strategy;
import com.tdd.model.helpers.XMLConstants;
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
	 * @throws com.tdd.model.exceptions.NoAvailableFactoryException 
     */
    public Enemy createEnemy(Stage stage, GameConfigurations givenConfigs, Position givenPosition, String status,String sense,String personality) throws NoAvailableFactoryException {
        Enemy enemy = null;
        StrategyFactorySearcher strategyFactorySearcher = new StrategyFactorySearcher(1,1);
        //Personality o status debería indicar que estrategia usar
        Strategy strategy = strategyFactorySearcher.getFactory(StrategyFactorySearcher.StrategyName.LAZYSTRATEGY).getStrategy(enemy);
        StateFactory stateFactory = new StateFactory(null, 1, 2);
        EnemyFactorySearcher enemyFactory = new EnemyFactorySearcher();
       
        return enemyFactory.getFactory(XMLConstants.GHOST).getEnemy(stage, givenPosition, stateFactory, strategy);
    }

}
