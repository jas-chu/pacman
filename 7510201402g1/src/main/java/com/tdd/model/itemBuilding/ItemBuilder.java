/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdd.model.itemBuilding;

import com.tdd.application.configuration.LevelConfigurationsReader;
import com.tdd.model.exceptions.NoAvailableFactoryException;
import com.tdd.model.stage.Labyrinth;
import com.tdd.model.stageAbstractions.Consumable;
import com.tdd.model.stageAbstractions.Position;

/**
 *
 *
 */
public class ItemBuilder {

    /**
     *
     * @param labyrinth
     * @param position
     * @param cellContent defined by XMLConstants
	 * @param givenConfigs
     * @return
	 * @throws com.tdd.model.exceptions.NoAvailableFactoryException
     */
    public Consumable createItem(Labyrinth labyrinth, Position position, String cellContent,
					LevelConfigurationsReader givenConfigs) throws NoAvailableFactoryException {
		
        ItemFactorySearcher itemFactory = new ItemFactorySearcher();
        return itemFactory.getFactory(cellContent).createItem(labyrinth, position, givenConfigs);
    }
}
