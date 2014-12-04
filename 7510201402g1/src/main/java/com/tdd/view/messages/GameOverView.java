package com.tdd.view.messages;

import com.tdd.view.helpers.ViewConstants;
import java.awt.Color;
import java.awt.Font;

/**
 *
 *
 */
public class GameOverView extends Message {

    public GameOverView() {
        super();
        this.setGameOvertLayout();
        this.setText("GAME OVER!!!");        
        
    }

    private void setGameOvertLayout() {        
        this.setFont(new Font("Consola", 40, 60));
        this.setForeground(Color.red);
        this.setBounds(150, 200, ViewConstants.LABEL_WIDTH, ViewConstants.LABEL_HEIGHT);    
    }
}