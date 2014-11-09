package com.tdd.application.main;


public class Program {
	
	public static void main(String[] args) {
		if (args.length > 0) {
			Application app = new Application(args[0]);
			app.run();
		}
	}
	
}
