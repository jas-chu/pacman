package com.tdd.application.main;

import com.tdd.model.exceptions.MalformedXMLException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Program {
	public static final String NO_PACMAN_APP = "0";
	public static final String NO_ENEMIES_APP = "1";
	public static final String NORMAL_APP = "2";
	
	private static Map<String,Application> createAppMap(long cycles) {
		Map<String,Application> apps = new HashMap<String,Application>();
		apps.put(NO_PACMAN_APP, new NoPacmanApplication(cycles));
		apps.put(NO_ENEMIES_APP, new NoEnemiesApplication());
		apps.put(NORMAL_APP, new NormalApplication());
		return apps;
	}
	
	public static void main(String[] args) {
		String game = "2";
		long cycles = 12;
		if (args.length > 0) game = args[0];
		if (args.length > 1) cycles = Long.parseLong(args[1]);
		Map<String,Application> apps = createAppMap(cycles);
		Application app = apps.get(game);
		try {
			app.createGame();
		} catch (MalformedXMLException ex) {
			Logger.getLogger(Application.class.getName()).log(Level.SEVERE, null, ex);
		}
		app.run();
	}
	
}
