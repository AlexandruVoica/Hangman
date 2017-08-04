package com.hangman;

public class HangmanView {

	private HangmanModel model;
	private char maskSign;

	public HangmanView(HangmanModel model, char maskSign) {
		this.model = model;
		this.maskSign = maskSign;
	}

	public void drawHangman(int tryNumber) {

	}

	public void writeRemainingAttempts() {
		System.out.println("You have " + model.getRemainingAttempts() + " attempts remaining.");
	}

	public void writeMaskedWord() {
		int index = 0;
		for (Boolean letterState : model.getLetterStates()) {
			if (letterState) {
				System.out.print(model.getWord().charAt(index));
			} else {
				System.out.print(maskSign);
			}
			System.out.print(" ");
			index++;
		}
		System.out.println();
	}

	public void writeAttemptedLetters() {
		System.out.print("The letters you've already tried: ");
		// for (Character letter : model.getAttemptedLetters())
		for (int i = 0; i < model.getAttemptedLetters().size(); i++) {
			System.out.print(model.getAttemptedLetters().get(i));
			if (i < model.getAttemptedLetters().size() - 1) {
				System.out.print(", ");
			}
		}
		System.out.println();
	}
}
