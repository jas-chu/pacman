package com.tdd.application.main;

import org.newdawn.slick.SlickException;

public class Program {

    public static void main(String[] args) {
        if (args.length > 0) {
            String name = args[0];
            String xmlGamePath = args[1];
            try {
                Application app = new Application(name,xmlGamePath);
                app.run();
            } catch (SlickException slickException) {
                slickException.printStackTrace();
            }
            
        }
    }

}
