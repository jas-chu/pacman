package com.tdd.application.main;

import com.tdd.model.exceptions.NoAvailableFactoryException;
import java.util.logging.Level;
import java.util.logging.Logger;


public class Program {
	
	public static void main(String[] args) {
		if (args.length > 0) {
			try {
				Application app = new Application(args[0]);
				app.run();
			} catch (NoAvailableFactoryException ex) {
				Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
	
}
