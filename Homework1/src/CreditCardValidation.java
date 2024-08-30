import java.util.InputMismatchException;
import java.util.Scanner;

//Credit card algorithm (Hans Luhn)
//valid 4388576018410707
//not valid 4388576018402626
public class CreditCardValidation {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("Enter Credit Card Number...");

		while (true) {
			try {
				Long cardNum = input.nextLong();
				String cardString = cardNum.toString();

				if (cardString.length() == 16) {
<<<<<<< HEAD
					
=======
>>>>>>> 78d6d69d183adbbd0939e4cb5d4a5e9eacea7029
					System.out.println(isValid(cardNum));
					break;
				} else {
					System.out.println("Must be 16 digits...");
					continue;
				}
			} catch (InputMismatchException e) {
				System.out.println("Enter a Number...");
				input.next();
			}
		}

	}

	private static int sumOfDoubleEvenPlace(Long cardString) {
		long cardNum = (long) cardString;
		int digit = 0;
		int sum = 0;
		for (int i = 15; i >= 0; i--) {
			// traverses backwards if index is even digit is multiplied by doubleNum value
			// if its less than 10 its immediately multiplied than added to sum

			if (i % 2 == 0 || i == 0) {
				digit = (int) (cardNum % 10);
				System.err.println(digit);
				sum = sum + getDigit(digit);
				cardNum = cardNum / 10; // remove a number each pass through the loop

			} else {
				cardNum = cardNum / 10;
			}
		}
		System.out.println(sum);
		return sum;
	}

	private static int getDigit(int digit) {
		int sum = 0;
		if (2 * digit < 10) {
			sum = sum + (2 * digit);
		} else { // else it will take the first number and the last number add them together a
					// then
					// add it to the sum
			sum = sum + ((2 * digit) / 10) + ((2 * digit) % 10);

		}

		return sum;
	}

	private static int sumOfOddPlace(Long cardNum) {
		long cardNumOdd = (long) cardNum;
		int digitOdd = 0;
		int oddSum = 0;
		for (int i = 15; i >= 0; i--) {
			if (i % 2 != 0) {
				digitOdd = (int) (cardNumOdd % 10);
				oddSum = oddSum + digitOdd;
				cardNumOdd = cardNumOdd / 10;
			} else {
				cardNumOdd = cardNumOdd / 10;

			}

		}

		return oddSum;
	}

	private static String isValid(long cardNum) {
		int sum = sumOfDoubleEvenPlace(cardNum);
		int oddSum = sumOfOddPlace(cardNum);
		String valid = null;

		if ((sum + oddSum) % 10 == 0) {
			valid = "Valid";
		} else {
			valid = "Not valid";
		}
		return valid;
	}

}
