package com.tdd.view.messages;

import java.awt.Color;
import java.awt.Font;
import javax.swing.JLabel;

/**
 *
 *
 */
public abstract class Message extends JLabel {

    protected String text;

    public Message() {
        this.setDefaultLayout();
    }

    public Message(String text) {
        this.text = text;
        this.setText(text);
        
    }

    protected void setDefaultLayout() {
        this.setFont(new Font("Arial", 0, 40));
        this.setForeground(Color.blue);
        this.setBounds(100, 0, 200, 200);

    }

}
