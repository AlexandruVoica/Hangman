package com.hangman;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class HangmanModel {

	private String word;
	private List<Character> attemptedLetters;
	//if true, the letter is visible, else, the letter is hidden (underscore)
	private List<Boolean> letterStates;
	private int maxAttempts;
	
	public HangmanModel(String word, int maxAttempts, int shownLettersCount) {
		this.word = word;
		this.maxAttempts = maxAttempts;
		this.attemptedLetters = new LinkedList<Character>();
		this.letterStates = new ArrayList<Boolean>();
		for(int i = 0; i < word.length();i++) {
			letterStates.add(Boolean.valueOf(false)); //add(new Boolean.valueOf(false)) or add(false); 
		}
		Random r = new Random();
		int count = shownLettersCount;
		while (count > 0) {
		 	int index = r.nextInt(word.length()) ;
			if (!(letterStates.get(index))) {
				letterStates.set(index, true);
				count--;
			}
		}
	}
	
	public String getWord() {
		return word;
	}
	
	public List<Boolean> getLetterStates() {
		return letterStates;
	}
	
	public List<Character> getAttemptedLetters() {
		return attemptedLetters;
	}
	
	public int getMaxAttempts() {
		return maxAttempts;
	}
	
	public int getAttemptedLettersCount() {
		return attemptedLetters.size();
	}
	
	public int getRemainingAttempts() {
		return maxAttempts - attemptedLetters.size();
	}

	public boolean isVictoryConditionAchieved() {
		for (Boolean letterState : letterStates) {
			if (!(letterState)) {
				return false;
			}
		}
		return true;
	}

}
