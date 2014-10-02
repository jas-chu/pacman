/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package com.tdd.model.cell.cellFactory;

import com.tdd.model.cell.ClearCell;
import com.tdd.model.stageAbstractions.Cell;

/**
 *
 * 
 */
public class ClearCellFactory implements CellFactory{

    @Override
    public Cell getCell() {
        return new ClearCell();
    }

}
