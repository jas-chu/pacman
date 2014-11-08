package com.tdd.application.main;


public class Program {
	public static final String NO_PACMAN_LEVEL = "0";
	public static final String KEYBOARD_LEVEL = "1";
	public static final String XML_LEVEL = "2";
	
	public static void main(String[] args) {
		String game = "2";
		long cycles = 12;
		if (args.length > 0) game = args[0];
		if (args.length > 1) cycles = Long.parseLong(args[1]);
	}
	
}
