package com.tdd.model.enemy.enemyBuilding;

import com.tdd.application.configuration.LevelConfigurationsReader;
import com.tdd.model.directionFactory.DirectionGenerator;
import com.tdd.model.exceptions.NoAvailableFactoryException;
import com.tdd.model.states.StateFactory;
import com.tdd.model.helpers.XMLConstants;
import com.tdd.model.helpers.XMLReader;
import com.tdd.model.stageAbstractions.Direction;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.Position;
import com.tdd.model.stageAbstractions.Stage;
import com.tdd.model.stageAbstractions.StrategyFactory;
import com.tdd.model.strategyFactory.StrategyFactorySearcher;
import java.util.List;
import javax.management.AttributeNotFoundException;
import org.w3c.dom.Node;

/**
 *
 *
 */
public class EnemyBuilder {

    /**
     * 
     * @param stage
     * @param givenConfigs
     * @param givenPosition
     * @param ghostNode
     * @return
     * @throws NoAvailableFactoryException
     * @throws AttributeNotFoundException 
     */
    public Enemy createEnemy(Stage stage, LevelConfigurationsReader givenConfigs, Position givenPosition, Node ghostNode) throws NoAvailableFactoryException, AttributeNotFoundException {

        String sense = XMLReader.getAttributeValue(ghostNode, XMLConstants.SENSE);
        String personality = XMLReader.getAttributeValue(ghostNode, XMLConstants.PERSONALITY);
        String status = XMLReader.getAttributeValue(ghostNode, XMLConstants.STATUS);

        String translatePersonality = givenConfigs.getGameConstants().getInvertedStrategyValueTranslation(personality);
        String translateSense = givenConfigs.getGameConstants().getInvertedDirectionValueTranslation(sense);
        String translateStatus = givenConfigs.getGameConstants().getInvertedStatusValueTranslation(status);
        
        int ghostVision = givenConfigs.getGhostVision();
        int ghostIncrementalVision = givenConfigs.getGhostIncrementalVision();
        List<Long> ghostAngerWaitingCycles = givenConfigs.getGhostAngerWaitingCycles();
        int ghostDeadWaitingCycles = givenConfigs.getGhostDeadWaitingCycles();
        int ghostPreyWaitingCycles = givenConfigs.getGhostPreyWaitingCycles();

        StrategyFactorySearcher strategyFactorySearcher = new StrategyFactorySearcher(ghostVision, ghostIncrementalVision);
        EnemyFactorySearcher enemyFactory = new EnemyFactorySearcher();

        StrategyFactory strategyFactory = strategyFactorySearcher.getFactory(translatePersonality);
        StateFactory stateFactory = new StateFactory(ghostAngerWaitingCycles, ghostDeadWaitingCycles, ghostPreyWaitingCycles);
        DirectionGenerator directionGenerator = new DirectionGenerator();
        Direction direction = directionGenerator.createDirection(translateSense);
        
        Enemy enemy = enemyFactory.getFactory(XMLConstants.GHOST).getEnemy(stage, givenPosition, stateFactory, strategyFactory);
        enemy.setSense(direction);
        return enemy;
    }

}
