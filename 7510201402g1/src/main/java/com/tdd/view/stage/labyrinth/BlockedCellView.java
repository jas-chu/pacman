/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdd.view.stage.labyrinth;

import com.tdd.model.cell.BlockedCell;
import com.tdd.view.Observador;
import java.util.Observable;

/**
 *
 *
 */
public class BlockedCellView extends Observador {

    public BlockedCellView(BlockedCell blockedCell) {
        this.observable = blockedCell;
    }

    @Override
    public void update(Observable o, Object arg) {
        System.out.println("actualizacion de " + o + arg);
    }

}
