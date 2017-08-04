package com.hangman;

import java.util.Scanner;

public class HangmanController {

	private HangmanModel model;
	private HangmanView view;
	
	public HangmanController(HangmanModel model, HangmanView view) {
		this.model = model;
		this.view = view;
	}
	
	public HangmanController(String word, int maxAttempts, int shownLetterCount, char maskSign) {
		this.model = new HangmanModel(word, maxAttempts, shownLetterCount);
		this.view = new HangmanView(model, maskSign);
	}
	
	public void runGame() {
		Scanner input = new Scanner(System.in);
		while (model.getRemainingAttempts() > 0 && !model.isVictoryConditionAchieved()) { 
			view.drawHangman(model.getRemainingAttempts());
			System.out.println();
			view.writeMaskedWord();
			System.out.println();
			view.writeRemainingAttempts();
			System.out.println();
			view.writeAttemptedLetters();
			System.out.println();
			String letter = null;
			do {
				System.out.println("Give letter: ");
				letter = input.next();
			} while (processLetter(letter.charAt(0)));
		}
		
		if (model.isVictoryConditionAchieved()) {
			System.out.println("Congratulations!");
		} else {
			System.out.println("You have lost. Try again!");
		}
		input.close();
	}
	
	public boolean processLetter(char letter) {
		if (model.getAttemptedLetters().contains(letter)) {
			System.out.println("You've already tried that letter.");
			return true;
		} else if (model.getWord().indexOf(letter) >= 0) {
			int index = model.getWord().indexOf(letter);
			while (index < model.getWord().length()) {
				if(model.getWord().charAt(index) == letter) {
					model.getLetterStates().set(index, true);
				}			
				index++;
			}	
		} else {
			model.getAttemptedLetters().add(letter);
		}
		return false;
	}
	
}
