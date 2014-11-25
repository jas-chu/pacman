package com.tdd.view.messages;

import java.util.Observer;

/**
 *
 * 
 */
public abstract class DynamicMessage extends Message implements Observer{
    public DynamicMessage(){
        super("");
    }

}
