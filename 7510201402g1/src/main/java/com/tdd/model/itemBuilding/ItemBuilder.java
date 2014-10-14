/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdd.model.itemBuilding;

import com.tdd.model.exceptions.NoAvailableFactoryException;
import com.tdd.model.stage.Labyrinth;
import com.tdd.model.stageAbstractions.Item;
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
     * @return
     */
    public Item createItem(Labyrinth labyrinth, Position position, String cellContent) throws NoAvailableFactoryException {
        ItemFactorySearcher itemFactory = new ItemFactorySearcher();
        return itemFactory.getFactory(cellContent).getItem(labyrinth, position);
    }
}
