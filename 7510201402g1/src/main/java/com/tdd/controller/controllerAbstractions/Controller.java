/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.tdd.controller.controllerAbstractions;

import com.tdd.application.gameAbstractions.GameLevel;
import com.tdd.application.gameAbstractions.PacmanGame;
import com.tdd.view.manager.ViewManager;

/**
 *
 *
 */
public abstract class Controller {

    private ViewManager view;
    private PacmanGame model;

    public Controller(ViewManager view, PacmanGame model) {
        this.view = view;
        this.model = model;
    }
}
