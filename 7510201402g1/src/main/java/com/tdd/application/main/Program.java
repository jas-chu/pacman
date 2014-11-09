package com.tdd.application.main;

import com.tdd.model.exceptions.NoAvailableFactoryException;
import org.newdawn.slick.SlickException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Program {
	
	public static void main(String[] args) {
		if (args.length > 0) {
			try {
				Application app = new Application("Pacman", args[0]);
				app.run();
			} catch (NoAvailableFactoryException | SlickException ex) {
				Logger.getLogger(Program.class.getName()).log(Level.SEVERE, null, ex);
			}
		}
	}
	
}
