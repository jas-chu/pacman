package com.tdd.application.main;

import com.tdd.model.exceptions.NoAvailableFactoryException;
import java.awt.EventQueue;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Program {

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            if (args.length > 0) {
                try {
                    Application app = new Application("Pacman", args[0]);
                    app.show();
                    //app.run();

                } catch (NoAvailableFactoryException ex) {
                    Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
        });
    }

}
