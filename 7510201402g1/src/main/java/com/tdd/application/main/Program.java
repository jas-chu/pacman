package com.tdd.application.main;

import com.tdd.model.exceptions.MalformedXMLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Program {
	
	public static void main(String[] args) {
		Application app = new NoPacmanApplication(12);
		try {
			app.createGame();
		} catch (MalformedXMLException ex) {
			Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
		}
		app.run();
	}
	
}
