package com.tdd.view.messages;

import java.util.Observer;

/**
 *
 * 
 */
public abstract class DinamycMessage extends Message implements Observer{
    public DinamycMessage(){
        super("");
    }
    public DinamycMessage(String text){
        super(text);
    }

}
