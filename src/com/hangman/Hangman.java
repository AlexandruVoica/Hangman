package com.hangman;

public class Hangman {

	public static void main(String[] args) {
	
		new HangmanController("protozoar", 6, 3, '_').runGame();

	}

}
