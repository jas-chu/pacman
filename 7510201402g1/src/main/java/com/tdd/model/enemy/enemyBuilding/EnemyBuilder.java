package com.tdd.model.enemy.enemyBuilding;

import com.tdd.application.gameAbstractions.GameConfigurations;
import com.tdd.model.directionFactory.DirectionGenerator;
import com.tdd.model.exceptions.NoAvailableFactoryException;
import com.tdd.model.ghost.StateFactory;
import com.tdd.model.helpers.XMLConstants;
import com.tdd.model.helpers.XMLReader;
import com.tdd.model.stageAbstractions.Direction;
import com.tdd.model.stageAbstractions.Enemy;
import com.tdd.model.stageAbstractions.Position;
import com.tdd.model.stageAbstractions.Stage;
import com.tdd.model.strategyFactory.StrategyFactory;
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
    public Enemy createEnemy(Stage stage, GameConfigurations givenConfigs, Position givenPosition, Node ghostNode) throws NoAvailableFactoryException, AttributeNotFoundException {

        String sense = XMLReader.getAttributeValue(ghostNode, XMLConstants.SENSE);
        String personality = XMLReader.getAttributeValue(ghostNode, XMLConstants.PERSONALITY);
        String status = XMLReader.getAttributeValue(ghostNode, XMLConstants.STATUS);

        String translatePersonality = givenConfigs.XMLGameConstants.getInvertedStrategyValueTranslation(personality);
        String translateSense = givenConfigs.XMLGameConstants.getInvertedDirectionValueTranslation(sense);
        String translateStatus = givenConfigs.XMLGameConstants.getInvertedStatusValueTranslation(status);
        
        int ghostVision = givenConfigs.ghostVision;
        int ghostIncrementalVision = givenConfigs.ghostIncrementalVision;
        List<Long> ghostAngerWaitingCycles = givenConfigs.ghostAngerWaitingCycles;
        int ghostDeadWaitingCycles = givenConfigs.ghostDeadWaitingCycles;
        int ghostPreyWaitingCycles = givenConfigs.ghostPreyWaitingCycles;

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
