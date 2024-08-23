import java.util.Random;
import java.util.Scanner;

public class Game {
	
	public static int allowedGuesses = 8;
	
	public static void main(String[] args) {
		
		String[] words = { "computer", "java", "coding", "bytes" };

		System.out.println("Welcome to Hangman! Guess the word");

		Random rand = new Random();

		int randomNumber = rand.nextInt(4);
		randomNumber = rand.nextInt(4);
		String word = words[randomNumber];
		String newWord = encryptWord(word);

		Scanner input = new Scanner(System.in);
		int attempts = 0;
		int match = 0;
		for (int i = 0; i < allowedGuesses; i++) {

			System.out.println("(Guess) Enter a letter in this word " + newWord);
			String guess = input.next();
			boolean check = checkGuess(guess);
			while (true) {
				if (check == true) {
					newWord = decryptWord(newWord, word, guess);
					attempts++;
					checkProgress(newWord, attempts);
					break;

				} else {
					System.err.println("Enter single character! ");
					guess = input.next();
					check = checkGuess(guess);
					continue;

				}
			}

		}

	}

	private static boolean checkGuess(String guess) {
		boolean check = false;
		if (guess.length() > 1 || guess.length() < 1 || guess.matches(".*\\d.*")) {
			check = false;
		} else {
			check = true;
		}

		return check;
	}

	private static String encryptWord(String word) {

		int wordLength = word.length();
		String newWord = "";
		for (int i = 0; i < wordLength; i++) {
			newWord = newWord + "*";
		}

		return newWord;
	}

	private static String decryptWord(String newWord, String word, String guess) {
		boolean match = false;
		char letter = ' ';
		int index = 0;

		for (char c1 : word.toCharArray()) {
			for (char c2 : guess.toCharArray()) {
				if (c1 == c2) {
					match = true;
					letter = word.toCharArray()[index];
					StringBuilder sb = new StringBuilder(newWord);
					sb.setCharAt(index, letter);
					newWord = sb.toString();
					break;
				}
			}
			index++;
		}
		return newWord;
	}

	private static void checkProgress(String newWord, int attempts) {
		int wordLength = newWord.length();
		boolean check = false;
		int count = 0;
		for (char x : newWord.toCharArray()) {
			count++;
			if (x == '*') {
				check = false;

				break;

			} else if (count == wordLength) {
				System.err.println(count);
				check = true;
			}
		}

		if (attempts == allowedGuesses) {
			System.out.println("Better luck next time. ");
		} else if (check == true) {
			System.out.println("Good job!");
		} else {
			return;
		}

	}

}
